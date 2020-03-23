(ns fira-code.not-space
  (:require
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]))


(defn regen-not-space [font]
  (let [not-spaces (->> (:glyphs font)
                     (remove #(re-find #"^\.|space$|space\." (:glyphname %)))
                     (remove #(= "0" (:export %)))
                     (map :glyphname)
                     (sort))]
    (println "  regenerated NotSpace:" (count not-spaces) "glyphs")
    (glyphs/update-code font :classes "NotSpace" (constantly (str/join " " not-spaces)))))