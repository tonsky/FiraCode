#^:shebang '[
              exec java -cp "$HOME/.m2/repository/org/clojure/clojure/1.7.0/clojure-1.7.0.jar" clojure.main "$0" "$@"]
             

(require '[clojure.string :as str])

(def file "FiraCode.glyphs")

(println "Looking for ligatures in" file "...\n")

;; [ ["dash" "greater" "greater"] ... ]
(def ligas (->> (slurp file)
                (re-seq #"glyphname = ([a-z_]+)\.liga;")
                (map second)
                set
                (mapv #(vec (str/split % #"_")))))
        

; (def ligas
;   [ ["hyphen"  "greater"]
;     ["greater" "equal"]    
;     ["equal"   "greater"]
;     ["hyphen"  "hyphen" "greater"]
;     ["equal"   "equal"  "greater"]
;     ["greater" "hyphen"]]) 

; (def ligas
;   [ ["slash"  "asterisk"]
;     ["slash"  "asterisk" "asterisk"]
;     ["asterisk" "asterisk"]
;     ["asterisk" "asterisk" "asterisk"]])


(defn liga->rule
  "[f f i] => { [CR CR i] f_f_i.liga
                [CR  f i] CR
                [ f  f i] CR }"
  [liga]
  (case (count liga)
    2 (let [[a b] liga]
        (str/replace
          (str "  lookup 1_2 {\n"
               "    ignore sub 1 1' 2;\n"
               "    ignore sub 1' 2 2;\n"
               "    sub CR 2' by 1_2.liga;\n"
               "    sub 1' 2  by CR;\n"
               "  } 1_2;")
          #"\d" {"1" a "2" b}))
    3 (let [[a b c] liga]
        (str/replace
          (str "  lookup 1_2_3 {\n"
               "    ignore sub 1 1' 2 3;\n"
               "    ignore sub 1' 2 3 3;\n"
               "    sub CR CR 3' by 1_2_3.liga;\n"
               "    sub CR 2' 3  by CR;\n"
               "    sub 1' 2  3  by CR;\n"
               "  } 1_2_3;")
          #"\d" {"1" a "2" b "3" c}))
    4 (let [[a b c d] liga]
        (str/replace
          (str "  lookup 1_2_3_4 {\n"
               "    ignore sub 1 1' 2 3 4;\n"
               "    ignore sub 1' 2 3 4 4;\n"
               "    sub CR CR CR 4' by 1_2_3_4.liga;\n"
               "    sub CR CR 3' 4  by CR;\n"
               "    sub CR 2' 3  4  by CR;\n"
               "    sub 1' 2  3  4  by CR;\n"
               "  } 1_2_3_4;")
          #"\d" {"1" a "2" b "3" c "4" d}))))
            

(println "feature calt {")
(println (->> ligas (sort-by count) (reverse) (map liga->rule) (str/join "\n\n")))
(println "}\n")

(println "Total ligatures count:" (count ligas))
(println " " (->> ligas
                  (group-by count)
                  (sort-by first)
                  (map (fn [[k v]] (str (count v) (case k 2 " pairs", 3 " triples", 4 " quadruples"))))
                  (str/join ", ")))
(println)
