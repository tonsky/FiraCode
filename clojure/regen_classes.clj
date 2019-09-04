;; clj -m regen-classes

(ns regen-classes
  (:require
    [clojure.string :as str]
    [glyphs :as glyphs]
    [flatland.ordered.map :refer [ordered-map]]))

(defn -main [& args]
  (let [path       (or (first args) "FiraCode.glyphs")
        font       (glyphs/load path)
        not-spaces (->> (:glyphs font)
                     (remove #(re-find #"^\.|space$|space\." (:glyphname %)))
                     (remove #(= "0" (:export %))))
        _          (println "Generating class:NotSpace with" (count not-spaces) "glyphs")
        class      (ordered-map
                     :code (str/join " " (map :glyphname not-spaces))
                     :name "NotSpace")
        classes    (->> (:classes font)
                     (remove #(= "NotSpace" (:name %)))
                     (cons class))
        font'      (assoc font :classes classes)
        _          (glyphs/save! path font')
        _          (println)]))

; (-main)