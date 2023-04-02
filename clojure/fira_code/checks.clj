(ns fira-code.checks
  (:require
   [clojure.string :as str]
   [fira-code.coll :as coll]
   [fira-code.glyphs :as glyphs]))

(def expected-widths #{"0" 0 1200})

(defn width-ok? [w]
  (expected-widths w))

(defn widths [font]
  (let [warnings (for [g (:glyphs font)
                       :when (not= "0" (:export g))
                       :let [ws (mapv :width (:layers g))]]
                   (cond
                     (not (apply = ws))
                     (str "Glyph '" (:glyphname g) "' has different widths: " (pr-str ws))

                     (not (width-ok? (first ws)))
                     (str "Glyph '" (:glyphname g) "' has unexpected width: " (pr-str (first ws)))

                     :else nil))]
    (remove nil warnings)))

(defn -main [& args]
  (let [path (or (first args) "FiraCode.glyphs")]
    (when-not (and (.exists (java.io.File. path))
                    (.canRead (java.io.File. path)))
      (println (str "ERROR: File not found or not readable: " path))
      (System/exit 1))
    (let [font (glyphs/load path)
          warnings (widths font)]
      (doseq [w warnings]
        (println (str "WARNING: " w)))
      font)))
