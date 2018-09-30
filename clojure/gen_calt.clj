(ns gen-calt
  (:require
    [clojure.string :as str]
    [parse-glyphs :as parse]))

(def ignores
  { ["slash" "asterisk"]
    (str
      "    ignore sub slash' asterisk slash;\n"
      "    ignore sub asterisk slash' asterisk;\n")

    ["asterisk" "slash"]
    (str
      "    ignore sub slash asterisk' slash;\n"
      "    ignore sub asterisk' slash asterisk;\n")

    ["asterisk" "asterisk"]
    (str
      "    ignore sub slash asterisk' asterisk;\n"
      "    ignore sub asterisk' asterisk slash;\n")

    ["asterisk" "asterisk" "asterisk"]
    (str
      "    ignore sub slash asterisk' asterisk asterisk;\n"
      "    ignore sub asterisk' asterisk asterisk slash;\n")

    ["question" "equal"]
    "    ignore sub parenleft question' equal;\n"

    ["less" "equal"]
    "    ignore sub parenleft question less' equal;\n"

    ["question" "colon"]
    "    ignore sub parenleft question' colon;\n"
})

(defn liga->rule
  "[f f i] => { [LIG LIG i] f_f_i.liga
                [LIG   f i] LIG
                [ f    f i] LIG }"
  [liga]
  (case (count liga)
    2 (let [[a b] liga]
        (str/replace
          (str "  lookup 1_2 {\n"
               "    ignore sub 1 1' 2;\n"
               "    ignore sub 1' 2 2;\n"
               (get ignores liga)
               "    sub LIG 2' by 1_2.liga;\n"
               "    sub 1'  2  by LIG;\n"
               "  } 1_2;")
          #"\d" {"1" a "2" b}))
    3 (let [[a b c] liga]
        (str/replace
          (str "  lookup 1_2_3 {\n"
               "    ignore sub 1 1' 2 3;\n"
               "    ignore sub 1' 2 3 3;\n"
               (get ignores liga)
               "    sub LIG LIG 3' by 1_2_3.liga;\n"
               "    sub LIG  2' 3  by LIG;\n"
               "    sub 1'   2  3  by LIG;\n"
               "  } 1_2_3;")
          #"\d" {"1" a "2" b "3" c}))
    4 (let [[a b c d] liga]
        (str/replace
          (str "  lookup 1_2_3_4 {\n"
               "    ignore sub 1 1' 2 3 4;\n"
               "    ignore sub 1' 2 3 4 4;\n"
               (get ignores liga)
               "    sub LIG LIG LIG 4' by 1_2_3_4.liga;\n"
               "    sub LIG LIG  3' 4  by LIG;\n"
               "    sub LIG  2'  3  4  by LIG;\n"
               "    sub 1'   2   3  4  by LIG;\n"
               "  } 1_2_3_4;")
          #"\d" {"1" a "2" b "3" c "4" d}))))

(defn -main [& args]
  (let [file  (or (first args) "FiraCode.glyphs")
        _     (println "Looking for ligatures in" file "...\n")
        font  (parse/parse (slurp file))
        ligas (for [g (:glyphs font)
                    :let [name (:glyphname g)]
                    :when (str/ends-with? name ".liga")
                    :let [[_ liga] (re-matches #"([a-z_]+)\.liga" name)]]
                (str/split liga #"_"))] ;; [ ["dash" "greater" "greater"] ... ]

    (println "### start of generated calt\n")
    (println (->> ligas (sort-by count) (reverse) (map liga->rule) (str/join "\n\n")))
    (println "\n### end of generated calt\n")

    (println "Total ligatures count:" (count ligas))
    (println " " (->> ligas
                      (group-by count)
                      (sort-by first)
                      (map (fn [[k v]] (str (count v) (case k 2 " pairs", 3 " triples", 4 " quadruples"))))
                      (str/join ", ")))
    (println)))

;; (-main)