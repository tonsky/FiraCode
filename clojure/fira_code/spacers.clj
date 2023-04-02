(ns fira-code.spacers
  (:require
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]
   [fira-code.time :as time]))

(defn spacer [name]
  {:color 3
   :glyphname name
   :lastChange (time/now-str)
   :layers [{:layerId (:Light glyphs/weights) :width 1200}
            {:layerId (:Bold glyphs/weights) :width 1200}]})

(defn add-spacers [font ligature-names]
  (let [needed   (->> (into #{} cat ligature-names)
                   (map #(str % ".spacer")))
        existing (->> (:glyphs font)
                   (map :glyphname)
                   (filter #(str/ends-with? % ".spacer")))
        new      (->> (remove (set existing) needed)
                   (sort-by str/lower-case))]
    (if-not (empty? new)
      (do
        (println "  added glyphs: " (str/join " " new))
        (update font :glyphs #(into % (map spacer new))))
      font)))
