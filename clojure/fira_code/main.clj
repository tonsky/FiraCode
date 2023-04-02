(ns fira-code.main
  (:require
   [clojure.string :as str]
   [fira-code.calt :as calt]
   [fira-code.coll :as coll]
   [fira-code.checks :as checks]
   [fira-code.classes :as classes]
   [fira-code.features :as features]
   [fira-code.glyphs :as glyphs]
   [fira-code.not-space :as not-space]
   [fira-code.spacers :as spacers]
   [fira-code.time :as time]
   [flatland.ordered.map :refer [ordered-map]]))


(defn load-font [path]
  "Loads the font object from the given file path, or returns nil if the file
  cannot be read."
  (try
    (glyphs/load path)
    (catch Exception _ nil)))

(defn save-font! [path font]
  "Saves the given font object to the given file path, or returns nil if the
  file cannot be written."
  (try
    (glyphs/save! path font)
    (catch Exception _ nil)))

(defn modify-font [font]
  "Applies various transformations to the given font's glyphs, including
  replacing ligatures with corresponding sub-glyph sequences, filling in missing
  class and feature definitions, adding spacers between certain glyphs,
  regenerating not-space glyphs, and adjusting glyph widths to fit within their
  bounding boxes."
  (-> font
      (calt/replace-calt (extract-ligatures font))
      (classes/fill-all)
      (features/fill-all)
      (add-spacers)
      (not-space/regen-not-space)
      (checks/widths)))

(defn extract-ligatures [font]
  "Returns a sequence of ligature names extracted from the given font's glyphs."
  (for [g (:glyphs font)
        :let [name (:glyphname g)]
        :when (str/ends-with? name ".liga")
        :when (not= "0" (:export g))
        :let [[_ liga] (re-matches #"([A-Za-z_]+)\.liga" name)]]
    (str/split liga #"_")))

(defn add-spacers [font]
  "Adds spacers between certain pairs of glyphs in the given font, according to
  a fixed set of rules. Returns the modified font."
  (let [rules (coll/ordered-map
                :greater-greater [:greater :greater]
                :less-less [:less :less]
                :hyphen-greater [:hyphen :greater]
                :hyphen-less [:hyphen :less]
                :hyphen-colon [:hyphen :colon])]
    (spacers/add-spacers font rules)))


(defn -main [& args]
  (let [path (or (first args) "FiraCode.glyphs")
        font (load-font path)]
    (when font
      (let [font' (modify-font font)]
        (save-font! path font')
        (println "Font modification complete."))))))
