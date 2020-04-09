(ns fira-code.calt
  (:require
   [clojure.string :as str]
   [fira-code.coll :as coll]
   [fira-code.glyphs :as glyphs]
   [fira-code.time :as time]
   [flatland.ordered.map :refer [ordered-map]]))


;; No ligature should follow those sequences
(def ignore-prefixes
  [["parenleft" "question" "colon"]
   ;; #578 #624 Regexp lookahead/lookbehind
   ["parenleft" "question" "equal"]
   ["parenleft" "question" "less" "equal"]
   ["parenleft" "question" "exclam"]
   ["parenleft" "question" "less" "exclam"]
   ;; #850 PHP <?=
   ["less" "question" "equal"]
  ])


(defn gen-ignore-prefixes [liga]
  (str/join
    (for [prefix ignore-prefixes
          ;; try to match last N glyphs in `prefix` with N first in `liga`
          N (range (count liga) 0 -1)
          :when (= (take-last N prefix) (take N liga))]
      (str "  ignore sub"
        " " (str/join " " (drop-last N prefix))
        " " (first liga) "'"
        " " (str/join " " (drop 1 liga))
        ";\n"))))


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
    
    ;; #621 <||>
    ["less" "bar" "bar"]
    "  ignore sub less' bar bar greater;\n"

    ["bar" "bar" "greater"]
    "  ignore sub less bar' bar greater;\n"

    ;; #574 :>=
    ["colon" "greater"]
    "  ignore sub colon' greater equal;\n"

    ;; #548 >=<
    ["greater" "equal"]
    "  ignore sub greater' equal less;\n"

    ["equal" "less"]
    "  ignore sub greater equal' less;\n"

    ;; #593 {|}
    ["braceleft" "bar"]
    "  ignore sub braceleft' bar braceright;\n"

    ["bar" "braceright"]
    "  ignore sub braceleft bar' braceright;\n"

    ;; #593 [|]
    ["bracketleft" "bar"]
    "  ignore sub bracketleft' bar bracketright;\n"

    ["bar" "bracketright"]
    "  ignore sub bracketleft bar' bracketright;\n"

    ;; #410 <*>> <+>> <$>>
    ["greater" "greater"]
    (str "  ignore sub asterisk greater' greater;\n"
         "  ignore sub plus greater' greater;\n"
         "  ignore sub dollar greater' greater;\n")

    ;; #410 <*>>> <+>>> <$>>>
    ["greater" "greater" "greater"]
    (str "  ignore sub asterisk greater' greater greater;\n"
         "  ignore sub plus greater' greater greater;\n"    
         "  ignore sub dollar greater' greater greater;\n")

    ;; #410 <<*> <<+> <<$>
    ["less" "less"]
    (str "  ignore sub less' less asterisk;\n"
         "  ignore sub less' less plus;\n"
         "  ignore sub less' less dollar;\n")

    ;; #410 <<<*> <<<+> <<<$>
    ["less" "less" "less"]
    (str "  ignore sub less' less less asterisk;\n"
         "  ignore sub less' less less plus;\n"
         "  ignore sub less' less less dollar;\n")

    ;; #713 |-|
    ["bar" "hyphen"]
    "  ignore sub bar' hyphen bar;\n"

    ["hyphen" "bar"]
    "  ignore sub bar hyphen' bar;\n"

    ;; #968 [-> [--> [==> [=>
    ["equal" "greater"]
    "  ignore sub bracketleft equal' greater;\n"

    ["equal" "equal" "greater"]
    "  ignore sub bracketleft equal' equal greater;\n"

    ["equal" "equal"]
    "  ignore sub bracketleft equal' equal;\n"

    ["equal" "equal" "equal"]
    "  ignore sub bracketleft equal' equal equal;\n"

    ["hyphen" "greater"]
    "  ignore sub bracketleft hyphen' greater;\n"

    ["hyphen" "hyphen" "greater"]
    "  ignore sub bracketleft hyphen' hyphen greater;\n"

    ["hyphen" "hyphen"]
    "  ignore sub bracketleft hyphen' hyphen;\n"

    ["hyphen" "hyphen" "hyphen"]
    "  ignore sub bracketleft hyphen' hyphen hyphen;\n"
})


;; DO NOT generate ignores at all
(def skip-ignores? #{
  ;; #410 <<*>> <<+>> <<$>>
  ["less" "asterisk" "greater"]
  ["less" "plus" "greater"]
  ["less" "dollar" "greater"]
  ;; #795
  ["f" "l"] ["F" "l"] ["T" "l"]
})


;; DO NOT generate ligature
(def manual? #{
  ;; /\ \/
  ["slash" "backslash"]
  ["backslash" "slash"]
})


(defn liga->rule
  "[f f i] => { [LIG LIG i] f_f_i.liga
                [LIG   f i] LIG
                [ f    f i] LIG }"
  [liga]
  (case (count liga)
    2 (let [[a b] liga]
        (str/replace
          (str
            "lookup 1_2 {\n"
            (when-not (skip-ignores? liga)
              (str "  ignore sub 1 1' 2;\n"
                   "  ignore sub 1' 2 2;\n"))
            (gen-ignore-prefixes liga)
            (get ignores liga)
            "  sub 1.spacer 2' by 1_2.liga;\n"
            "  sub 1'       2  by 1.spacer;\n"
            ; "sub 1 2 by 1_2.liga;"
            "} 1_2;")
          #"\d" {"1" a "2" b}))
    3 (let [[a b c] liga]
        (str/replace
          (str
            "lookup 1_2_3 {\n"
            (when-not (skip-ignores? liga)
             (str "  ignore sub 1 1' 2 3;\n"
                  "  ignore sub 1' 2 3 3;\n"))
            (gen-ignore-prefixes liga)
            (get ignores liga)
            "  sub 1.spacer 2.spacer 3' by 1_2_3.liga;\n"
            "  sub 1.spacer 2'       3  by 2.spacer;\n"
            "  sub 1'       2        3  by 1.spacer;\n"
            ; "sub 1 2 3 by 1_2_3.liga;"
            "} 1_2_3;")
          #"\d" {"1" a "2" b "3" c}))
    4 (let [[a b c d] liga]
        (str/replace
          (str
            "lookup 1_2_3_4 {\n"
            (when-not (skip-ignores? liga)
              (str "  ignore sub 1 1' 2 3 4;\n"
                   "  ignore sub 1' 2 3 4 4;\n"))
            (gen-ignore-prefixes liga)
            (get ignores liga)
            "  sub 1.spacer 2.spacer 3.spacer 4' by 1_2_3_4.liga;\n"
            "  sub 1.spacer 2.spacer 3'       4  by 3.spacer;\n"
            "  sub 1.spacer 2'       3        4  by 2.spacer;\n"
            "  sub 1'       2        3        4  by 1.spacer;\n"
            ; "sub 1 2 3 4 by 1_2_3_4.liga;"
            "} 1_2_3_4;")
          #"\d" {"1" a "2" b "3" c "4" d}))
    5 (let [[a b c d e] liga]
        (str/replace
          (str
            "lookup 1_2_3_4_5 {\n"
            (when-not (skip-ignores? liga)
              (str "  ignore sub 1 1' 2 3 4 5;\n"
                   "  ignore sub 1' 2 3 4 4 5;\n"))
            (gen-ignore-prefixes liga)
            (get ignores liga)
            "  sub 1.spacer 2.spacer 3.spacer 4.spacer 5' by 1_2_3_4_5.liga;\n"
            "  sub 1.spacer 2.spacer 3.spacer 4'       5  by 4.spacer;\n"
            "  sub 1.spacer 2.spacer 3'       4        5  by 3.spacer;\n"
            "  sub 1.spacer 2'       3        4        5  by 2.spacer;\n"
            "  sub 1'       2        3        4        5  by 1.spacer;\n"
            ; "sub 1 2 3 4 5 by 1_2_3_4_5.liga;"
            "} 1_2_3_4_5;")
          #"\d" {"1" a "2" b "3" c "4" d "5" e}))
))


(defn compare-ligas [l1 l2]
  (cond
    (> (count l1) (count l2)) -1
    (< (count l1) (count l2)) 1
    :else (compare l1 l2)))


(defn replace-calt [font ligas]
  (let [ligas' (->> ligas
                 (remove manual?) 
                 (sort compare-ligas))
        calt   (->> ligas'
                 (map liga->rule)
                 (str/join "\n\n"))
        glyphs (map #(str (str/join "_" %) ".liga") ligas')
        counts (coll/group-by-to count count ligas')]

    (println "  generated calt:" 
      ; (str/join " " glyphs)
      (str
        #_"(" (get counts 2) " pairs, "
        (get counts 3) " triples, "
        (get counts 4) " quadruples, "
        (count ligas') " total" #_")"))

    (glyphs/update-code font :features "calt"
      #(str/replace %
         #"### start of generated calt\n[^#]+\n### end of generated calt\n"
         (str "### start of generated calt\n" calt "\n### end of generated calt\n")))))
