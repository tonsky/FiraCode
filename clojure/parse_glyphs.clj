(ns parse-glyphs
  (:require
    [clojure.java.io :as io]
    [fipp.edn :as fipp]))

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
      (loop []
        (advance!)
        (let [ch (current-char)]
          (cond
            (= ch \\) (do (.append sb \\) (advance!) (.append sb (current-char)) (recur))
            (= ch \") (do (advance!) (str sb))
            :else     (do (.append sb ch) (recur))))))))

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
        (re-matches #"[0-9]+" res) (Integer/parseInt res)
        (re-matches #"[0-9]+\.[0-9]+" res) (Double/parseDouble res)
        (re-matches #"[a-zA-Z][a-zA-Z\.0-9]*" res) (keyword res)
        :else res))))

(defn expect [c]
  (assert (= c (current-char)) (str "Expected '" c "', found " (current-char) " at " @*pos)))

(defn parse-map! []
  (skip-ws!)
  (when (= \{ (current-char))
    (advance!)
    (loop [m {}]
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

(defn -main [& args]
  (let [f (-> (slurp "FiraCode.glyphs") parse)]
    (with-open [os (io/writer "clojure/FiraCode.edn")]
      (binding [*out* os]
        (fipp/pprint f {:width 200})))))