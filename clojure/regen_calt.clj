(ns regen-calt
  (:require
    [clojure.string :as str]
    [glyphs :as glyphs]))

(def ignores
  { ["slash" "asterisk"]
    (str
      "  ignore sub slash' asterisk slash;\n"
      "  ignore sub asterisk slash' asterisk;\n")

    ["asterisk" "slash"]
    (str
      "  ignore sub slash asterisk' slash;\n"
      "  ignore sub asterisk' slash asterisk;\n")

    ["asterisk" "asterisk"]
    (str
      "  ignore sub slash asterisk' asterisk;\n"
      "  ignore sub asterisk' asterisk slash;\n")

    ["asterisk" "asterisk" "asterisk"]
    (str
      "  ignore sub slash asterisk' asterisk asterisk;\n"
      "  ignore sub asterisk' asterisk asterisk slash;\n")

    ["question" "equal"]
    "  ignore sub parenleft question' equal;\n"

    ["less" "equal"]
    "  ignore sub parenleft question less' equal;\n"

    ["question" "colon"]
    "  ignore sub parenleft question' colon;\n"

    ["less" "bar" "bar"]
    "  ignore sub less' bar bar greater;\n"

    ["bar" "bar" "greater"]
    "  ignore sub less bar' bar greater;\n"

    ["colon" "greater"]
    "  ignore sub colon' greater equal;\n"

    ["greater" "equal"]
    "  ignore sub greater' equal less;\n"

    ["equal" "less"]
    "  ignore sub greater equal' less;\n"
})

(defn liga->rule
  "[f f i] => { [LIG LIG i] f_f_i.liga
                [LIG   f i] LIG
                [ f    f i] LIG }"
  [liga]
  (case (count liga)
    2 (let [[a b] liga]
        (str/replace
          (str "lookup 1_2 {\n"
               "  ignore sub 1 1' 2;\n"
               "  ignore sub 1' 2 2;\n"
               (get ignores liga)
               "  sub LIG 2' by 1_2.liga;\n"
               "  sub 1'  2  by LIG;\n"
               "} 1_2;")
          #"\d" {"1" a "2" b}))
    3 (let [[a b c] liga]
        (str/replace
          (str "lookup 1_2_3 {\n"
               "  ignore sub 1 1' 2 3;\n"
               "  ignore sub 1' 2 3 3;\n"
               (get ignores liga)
               "  sub LIG LIG 3' by 1_2_3.liga;\n"
               "  sub LIG  2' 3  by LIG;\n"
               "  sub 1'   2  3  by LIG;\n"
               "} 1_2_3;")
          #"\d" {"1" a "2" b "3" c}))
    4 (let [[a b c d] liga]
        (str/replace
          (str "lookup 1_2_3_4 {\n"
               "  ignore sub 1 1' 2 3 4;\n"
               "  ignore sub 1' 2 3 4 4;\n"
               (get ignores liga)
               "  sub LIG LIG LIG 4' by 1_2_3_4.liga;\n"
               "  sub LIG LIG  3' 4  by LIG;\n"
               "  sub LIG  2'  3  4  by LIG;\n"
               "  sub 1'   2   3  4  by LIG;\n"
               "} 1_2_3_4;")
          #"\d" {"1" a "2" b "3" c "4" d}))))

(defn index-of [pred xs]
  (reduce (fn [i x] (if (pred x) (reduced i) (inc i))) 0 xs))

(defn replace-calt [font calt]
  (let [features (:features font)
        idx      (index-of #(= "calt" (:name %)) features)
        code     (get-in features [idx :code])
        code'    (str/replace code
                              #"### start of generated calt\n[^#]+\n### end of generated calt\n"
                              (str "### start of generated calt\n" calt "\n### end of generated calt\n"))]
    (assoc-in font [:features idx :code] code')))

(defn -main [& args]
  (let [file  (or (first args) "FiraCode.glyphs")
        _     (println "Parsing" file "...")
        font  (glyphs/parse (slurp file))
        ligas (for [g (:glyphs font)
                    :let [name (:glyphname g)]
                    :when (str/ends-with? name ".liga")
                    :let [[_ liga] (re-matches #"([a-z_]+)\.liga" name)]]
                (str/split liga #"_")) ;; [ ["dash" "greater" "greater"] ... ]
        calt  (->> ligas (sort-by count) (reverse) (map liga->rule) (str/join "\n\n"))
        font' (replace-calt font calt)]

    (println "Saving" file "...")
    (spit file (glyphs/serialize font'))

    (println "Total ligatures count:" (count ligas))
    (println " " (->> ligas
                      (group-by count)
                      (sort-by first)
                      (map (fn [[k v]] (str (count v) (case k 2 " pairs", 3 " triples", 4 " quadruples"))))
                      (str/join ", ")))
    (println)))

;; (-main)
