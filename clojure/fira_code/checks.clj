(ns fira-code.checks
  (:require
   [clojure.string :as str]
   [fira-code.coll :as coll]
   [fira-code.glyphs :as glyphs]))

(defn width-ok? [w]
  (#{"0" 0 1200} w))

(defn widths [font]
  (doseq [g     (:glyphs font)
          :when (not= "0" (:export g))
          :let  [[w & _ :as ws] (mapv :width (:layers g))]]
    (when-not (apply = ws) 
      (println (str "WARN glyph '" (:glyphname g) "' has different widths=" (pr-str ws))))
    (when-not (width-ok? w)
      (println (str "WARN glyph '" (:glyphname g) "' has unexpected width=" (pr-str w)))))
  font)

(defn -main [& args]
  (let [path (or (first args) "FiraCode.glyphs")
        font (glyphs/load path)]
    (widths font)))