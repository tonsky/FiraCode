(ns fira-code.checks
  (:require
   [clojure.string :as str]
   [fira-code.coll :as coll]
   [fira-code.glyphs :as glyphs]))


(defn width-ok? [w]
  (#{"0" 0 1200 2400} w))


(defn widths [font]
  (doseq [g     (:glyphs font)
          :when (not= "0" (:export g))
          l     (:layers g)
          :let  [w (:width l)]
          :when (not (width-ok? w))]
    (println (str "WARN glyph '" (:glyphname g) "' layer '" (:id (glyphs/layer l)) "' has width=" (pr-str w))))
  font)


(defn -main [& args]
  (let [path (or (first args) "FiraCode.glyphs")
        font (glyphs/load path)]
    (widths font)))

