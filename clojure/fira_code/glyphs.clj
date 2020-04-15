(ns fira-code.glyphs
  (:refer-clojure :exclude [load])
  (:require
    [clojure.java.io :as io]
    [clojure.string :as str]
    [fipp.edn :as fipp]
    [fira-code.coll :as coll]
    [flatland.ordered.map :refer [ordered-map]]))

(def ^:dynamic *str)
(def ^:dynamic *pos)

(defn current-char [] (nth @*str @*pos))

(defn advance! [] (swap! *pos inc))

(declare parse-anything!)

(defn skip-ws! []
  (loop []
    (case (current-char)
      \space   (do (advance!) (recur))
      \newline (do (advance!) (recur))
      nil)))

(defn parse-escaped-string! []
  (skip-ws!)
  (when (= \" (current-char))
    (let [sb (StringBuilder.)]
      (->
        (loop []
          (advance!)
          (let [ch (current-char)]
            (cond
              (= ch \\) (do (.append sb \\) (advance!) (.append sb (current-char)) (recur))
              (= ch \") (do (advance!) (str sb))
              :else     (do (.append sb ch) (recur)))))
        (str/replace "\\012" "\n")
        (str/replace "\\\"" "\"")
        (str/replace "\\\\" "\\")))))

(defn parse-string! []
  (skip-ws!)
  (let [sb (StringBuilder.)]
    (loop []
      (let [ch (current-char)]
        (cond
          (#{\space \newline \{ \} \( \) \; \, \" \=} ch) sb
          :else (do (.append sb ch) (advance!) (recur)))))
    (let [res (str sb)]
      (cond
        (re-matches #"-?[1-9][0-9]*" res)          (Integer/parseInt res)
        (re-matches #"-?[0-9]+\.[0-9]+" res)       (Double/parseDouble res)
        (re-matches #"[a-zA-Z][a-zA-Z\.0-9]*" res) (keyword res)
        :else res))))

(defn expect [c]
  (assert (= c (current-char))
    (str "Expected '" c
      "', found " (current-char)
      " at " @*pos
      " around here:\n" (subs @*str (max 0 (- @*pos 100)) (min (count @*str) (+ @*pos 100))))))

(defn parse-map! []
  (skip-ws!)
  (when (= \{ (current-char))
    (advance!)
    (loop [m (ordered-map)]
      (skip-ws!)
      (if (= \} (current-char))
        (do (advance!) m)
        (let [k (or (parse-escaped-string!) (parse-string!))
              _ (do (skip-ws!) (expect \=) (advance!))
              v (parse-anything!)
              v (if (keyword? v) (name v) v)
              _ (do (skip-ws!) (expect \;) (advance!))]
          (recur (assoc m k v)))))))

(defn parse-list! []
  (skip-ws!)
  (when (= \( (current-char))
    (advance!)
    (loop [l []]
      (skip-ws!)
      (if (= \) (current-char))
        (do (advance!) l)
        (let [v (parse-anything!)
              _ (skip-ws!)
              _ (when (not= \) (current-char))
                  (expect \,)
                  (advance!))]
          (recur (conj l v)))))))

(defn parse-anything! []
  (skip-ws!)
  (or
    (parse-map!)
    (parse-list!)
    (parse-escaped-string!)
    (parse-string!)))

(defn parse [s]
  (binding [*str (atom s)
            *pos (atom 0)]
    (parse-anything!)))

(def escapes {"\n" "\\012"
              "\"" "\\\""
              "\\" "\\\\"})

(def escape-re #"[\n\"\\]")

(defn- serialize-impl [form]
  (cond
    (string? form)     (if (re-matches #"[a-zA-Z0-9._/]+" form)
                         form 
                         (str \" (str/replace form escape-re escapes) \"))
    (keyword? form)    (name form)
    (number? form)     (str form)
    (instance? clojure.lang.MapEntry form)
                       (str
                         (serialize-impl (key form))
                         " = "
                         (if (= ".appVersion" (key form)) ;; https://github.com/googlefonts/glyphsLib/issues/209
                           (str \" (val form) \")
                           (serialize-impl (val form)))
                         ";")
    (sequential? form) (if (empty? form)
                         "(\n)"
                         (str "(\n" (str/join ",\n" (map serialize-impl form)) "\n)"))
    (map? form)        (if (empty? form)
                         "{\n}"
                         (str "{\n" (str/join "\n" (map serialize-impl form)) "\n}"))))

(defn serialize [font]
  (str (serialize-impl font) "\n"))

; (-> (slurp "FiraCode.glyphs") parse serialize (->> (spit "FiraCode_saved.glyphs")))

(defn load [path]
  (println (str "Parsing '" path "'..."))
  (parse (slurp path)))

(defn save! [path font]
  (println (str "Saving '" path "'..."))
  (spit path (serialize font)))

(defn -main [& args]
  (let [font (-> (slurp "FiraCode.glyphs") parse)]
    (with-open [os (io/writer "clojure/FiraCode.edn")]
      (binding [*out* os]
        (fipp/pprint font {:width 200})))))


(defn update-code [font key name f & args]
  (let [idx (coll/index-of #(= (:name %) name) (get font key))]
    (apply update-in font [key idx :code] f args)))


(def weights
  {:Light   "B67F0F2D-EC95-4CB8-966E-23AE86958A69"
   :Regular "UUID0"
   :Bold    "4B7A3BAF-EAD8-4024-9BEA-BB1DE86CFCFA"})


(defn layer [l]
  { :id (condp = (:layerId l)
          (:Light weights)   "Light"
          (:Regular weights) "Regular"
          (:Bold weights)    "Bold"
          (:layerId l))
    :width (:width l) })

(defn save-not600 []
  (let [font (-> (slurp "FiraCode.glyphs") parse)]
    (with-open [os (io/writer "clojure/FiraCode_not600.edn")]
      (binding [*out* os]
        (let [glyphs (for [glyph (:glyphs font)
                           :when (->> (:layers glyph)
                                      (filter #(contains? (set (vals weights)) (:layerId %)))
                                      (every? #(= 600 (:width %)))
                                      (not))]
                       {:glyphname (:glyphname glyph)
                        :layers    (mapv layer (:layers glyph))})]
          (doseq [glyph glyphs]
            (fipp/pprint glyph {:width 200}))
          (count glyphs))))))

;; (-main)
;; (save-not600)
;; (-> (slurp "FiraCode.glyphs") parse keys)
;; 