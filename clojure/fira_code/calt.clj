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


(def priorities
  {;; <|>
   ["less" "bar" "greater"]        0

   ;; |||> ||> |> <| <|| <|||
   ["bar" "bar" "bar" "greater"]   1
   ["bar" "bar" "greater"]         1
   ["bar" "greater"]               1
   ["less" "bar" "bar" "bar"]      1
   ["less" "bar" "bar"]            1
   ["less" "bar"]                  1

   ;; #346 We need << <<< >> >>> || ||| substituted before -- --- == ===
   ;; so that `ignore [less greater bar] hyphen hyphen` would not trigger
   ["less" "less"]                 2
   ["less" "less" "less"]          2
   ["greater" "greater"]           2
   ["greater" "greater" "greater"] 2
   ["bar" "bar"]                   2
   ["bar" "bar" "bar"]             2})


(def ignores
  (coll/multimap-by str
    ["slash" "asterisk"]
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

    ;; #1061
    ["colon" "colon"]
    (str "  ignore sub colon' colon [less greater];\n"
         "  ignore sub [less greater] colon' colon;\n")

    ["colon" "colon" "colon"]
    (str "  ignore sub colon' colon colon [less greater];\n"
         "  ignore sub [less greater] colon' colon colon;\n")

    ;; #621 <||>
    ["less" "bar" "bar"]
    "  ignore sub less' bar bar greater;\n"

    ["bar" "bar" "greater"]
    "  ignore sub less bar' bar greater;\n"

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
    "  ignore sub [asterisk plus dollar] greater' greater;\n"
    
    ;; #410 <*>>> <+>>> <$>>>
    ["greater" "greater" "greater"]
    "  ignore sub [asterisk plus dollar] greater' greater greater;\n"

    ;; #410 <<*> <<+> <<$>
    ["less" "less"]
    "  ignore sub less' less [asterisk plus dollar];\n"

    ;; #410 <<<*> <<<+> <<<$>
    ["less" "less" "less"]
    "  ignore sub less' less less [asterisk plus dollar];\n"

    ;; #948 [==[ ]==]
    ;; #968 [== ==]
    ["equal" "equal"]
    (str "  ignore sub bracketleft equal' equal;\n"
         "  ignore sub equal' equal bracketright;\n")

    ;; #948 [===[ ]===]
    ;; #968 [=== ===]
    ["equal" "equal" "equal"]
    (str "  ignore sub bracketleft equal' equal equal;\n"
         "  ignore sub equal' equal equal bracketright;\n")

    ;; #346 =:=
    ["colon" "equal"]
    "  ignore sub equal colon' equal;\n"

    ;; #346 =!=
    ["exclam" "equal"]
    "  ignore sub equal exclam' equal;\n"
    ;; #346 =!==
    ["exclam" "equal" "equal"]
    "  ignore sub equal exclam' equal equal;\n"

    ;; #346 =<= <=< <=> <=| <=: <=! <=/
    ["less" "equal"]
    (str "  ignore sub equal less' equal;\n"
         "  ignore sub less' equal [less greater bar colon exclam slash];\n")
    
    ;; #548 >=<
    ;; #346 =>= >=> >=< >=| >=: >=! >=/
    ["greater" "equal"]
    (str "  ignore sub equal greater' equal;\n"
         "  ignore sub greater' equal [less greater bar colon exclam slash];\n")

    ;; #346 >>->> >>=>>
    ;; #974 keep >>=
    ["greater" "greater"]
    (str "  ignore sub [hyphen equal] greater' greater;\n"
         "  ignore sub greater' greater hyphen;\n"
         "  ignore sub greater' greater equal [equal less greater bar colon exclam slash];\n")

    ;; #346 <<-<< <<=<<
    ;; #974 keep <<=
    ["less" "less"]
    (str "  ignore sub [hyphen equal] less' less;\n"
         "  ignore sub less' less hyphen;\n"
         "  ignore sub less' less equal [equal less greater bar colon exclam slash];\n")

    ;; #346 ||-|| ||=||
    ;; #974 keep ||=
    ["bar" "bar"]
    (str "  ignore sub [hyphen equal] bar' bar;\n"
         "  ignore sub bar' bar hyphen;\n"
         "  ignore sub bar' bar equal [equal less greater bar colon exclam slash];\n")

    ;; #816 //=
    ["slash" "slash"]
    (str "  ignore sub equal slash' slash;\n"
         "  ignore sub slash' slash equal;\n")

    ;; #346 <--> >--< |--|
    ["hyphen" "hyphen"]
    (str "  ignore sub [less greater bar] hyphen' hyphen;\n"
         "  ignore sub hyphen' hyphen [less greater bar];\n")

    ;; #346 <---> >---< |---|
    ["hyphen" "hyphen" "hyphen"]
    (str "  ignore sub [less greater bar] hyphen' hyphen hyphen;\n"
         "  ignore sub hyphen' hyphen hyphen [less greater bar];\n")

    ;; #346 <==> >==< |==| /==/ =:== =!== ==:= ==!=
    ["equal" "equal"]
    (str "  ignore sub equal [colon exclam] equal' equal;\n"
         "  ignore sub [less greater bar slash] equal' equal;\n"
         "  ignore sub equal' equal [less greater bar slash] ;\n"
         "  ignore sub equal' equal [colon exclam] equal;\n")

    ;; #346 <===> >===< |===| /===/ =:=== =!=== ===:= ===!=
    ["equal" "equal" "equal"]
    (str "  ignore sub equal [colon exclam] equal' equal equal;\n"
         "  ignore sub [less greater bar slash] equal' equal equal;\n"
         "  ignore sub equal' equal equal [less greater bar slash];\n"
         "  ignore sub equal' equal equal [colon exclam] equal;\n")
))


;; DO NOT generate ignores at all
(def skip-ignores? #{
  ;; #410 <<*>> <<+>> <<$>>
  ["less" "asterisk" "greater"]
  ["less" "plus" "greater"]
  ["less" "dollar" "greater"]
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
  (let [p1 (priorities l1 Long/MAX_VALUE)
        p2 (priorities l2 Long/MAX_VALUE)
        pc (compare p1 p2)
        c1 (count l1)
        c2 (count l2)
        cc (compare c1 c2)]
    (cond
      (not= 0 pc) pc     ;; lower priority first
      (not= 0 cc) (- cc) ;; longer first
      :else (compare l1 l2)))) ;; alphabetical


(defn replace-calt [font ligas]
  (let [ligas' (->> ligas
                 (remove manual?) 
                 (sort compare-ligas))
        calt   (->> ligas'
                 (map liga->rule)
                 (str/join "\n\n"))
        glyphs (map #(str (str/join "_" %) ".liga") ligas')
        counts (coll/group-by-to count count ligas')]

    (when-some [unused (not-empty (reduce dissoc ignores ligas'))]
      (println "  WARN Unused ignores" (str/join " " (keys unused))))

    (when-some [unused (not-empty (reduce disj skip-ignores? ligas'))]
      (println "  WARN Unused skip-ignores?" (str/join " " unused)))

    (when-some [unused (not-empty (reduce disj manual? ligas))]
      (println "  WARN Unused manual?" (str/join " " unused)))

    (println "  generated calt:" 
      ; (str/join " " glyphs)
      (str
        #_"(" (get counts 2) " pairs, "
        (get counts 3) " triples, "
        (get counts 4) " quadruples, "
        (count ligas') " total" #_")"))

    (glyphs/update-code font :features "calt" (constantly calt))))
