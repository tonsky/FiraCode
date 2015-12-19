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


(defn liga->rules
  "[f f i] => { [CR CR i] f_f_i.liga
                [CR  f i] CR
                [ f  f i] CR }"
  [liga CR]
  (case (count liga)
    2 (let [[a b] liga]
       { [CR  b] (str a "_" b ".liga")
         [ a  b] CR}) 
    3 (let [[a b c] liga]
       { [CR CR  c] (str a "_" b "_" c ".liga")
         [CR  b  c] CR
         [ a  b  c] CR}) 
    4 (let [[a b c d] liga]
       { [CR CR CR  d] (str a "_" b "_" c "_" d ".liga")
         [CR CR  c  d] CR
         [CR  b  c  d] CR
         [ a  b  c  d] CR})))


(defn any? [p & colls]
  (if colls
    (let [[coll & cs] colls]
      (some #(apply any? (partial p %) cs) coll))
    (p)))


(defn conflicts? [r1 r2]
  (when (.startsWith (first r2) "CR.") ;; we accept that higher-len ligatures can override lower-length
                                       ;; but once replacement has started (first glyph in rule is CR.*)
                                       ;; there should be no possibility for conflits
    (let [l1 (count r1)
          l2 (count r2)
          prefix1 (subvec r1 0 l2)]
      (= r2 prefix1))))


(def all-rules
  (reduce
    (fn [generated liga]
      (merge generated 
        ;; looking for smallest i that does not conflict
        ;; with any of previous rules
        (some (fn [i]
                (let [CR (str "CR." (String/format "%02d" (to-array [i])))
                      rs (liga->rules liga CR)]  
                  ; (println (keys generated) (keys rs))
                  (when-not (any? conflicts? (keys generated) (keys rs))
                    rs)))
              (range))))
    {}
    (->> ligas (sort-by count) reverse)))
    
    
(defn priority-fn [[from to]]
  [;; first compare how many CRs are there (more is better)
   (- (count (filter #(re-matches #"CR\.\d+" %) from)))
   ;; then overal length (more is better)
   (- (count from))
   ;; then alphabetical sort with coercing each vector to the same length
   (into from (repeat (- 4 (count from)) "z"))])


(def table (->> all-rules
                (sort-by priority-fn)))


(defn rule->str [[from to]]
  (loop [res             "sub"
         seen-non-empty? false
         tokens          from]
    (if-let [token (first tokens)]
      (let [class? (.startsWith token "@")
            CR?    (.startsWith token "CR.")
            escaped-token (cond
                            class?          token
                            CR?             (str "\\" token)
                            seen-non-empty? (str "\\" token)
                            :else           (str "\\" token "'"))]
        (recur (str res " " escaped-token) (not CR?) (next tokens)))
      (str res " by \\" to ";"))))
      

(println "feature calt {")
(println " " (->> table (map rule->str) (str/join "\n  ")))
(println "}\n")



(apply println "Placeholders:\n " (->> table (mapcat first) (filter #(.startsWith % "CR.")) distinct sort))
(println)


(println "Total ligatures count:" (count ligas))
(println " " (->> ligas
                  (group-by count)
                  (sort-by first)
                  (map (fn [[k v]] (str (count v) (case k 2 " pairs", 3 " triples", 4 " quadruples"))))
                  (str/join ", ")))
(println)

(println "Total rules count:" (count table))
