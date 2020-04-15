(ns fira-code.main
  (:require
   [clojure.string :as str]
   [fira-code.calt :as calt]
   [fira-code.coll :as coll]
   [fira-code.checks :as checks]
   [fira-code.glyphs :as glyphs]
   [fira-code.not-space :as not-space]
   [fira-code.spacers :as spacers]
   [fira-code.time :as time]
   [flatland.ordered.map :refer [ordered-map]]))


(defn -main [& args]
  (let [path   (or (first args) "FiraCode.glyphs")
        font   (glyphs/load path)
        ligas  (for [g (:glyphs font)
                     :let [name (:glyphname g)]
                     :when (str/ends-with? name ".liga")
                     :when (not= "0" (:export g))
                     :let [[_ liga] (re-matches #"([A-Za-z_]+)\.liga" name)]]
                 (str/split liga #"_")) ;; [ ["dash" "greater" "greater"] ... ]
        font'  (-> font
                 (calt/replace-calt ligas)
                 (spacers/add-spacers ligas)
                 (not-space/regen-not-space)
                 (checks/widths))]
    (glyphs/save! path font')
    (println)))