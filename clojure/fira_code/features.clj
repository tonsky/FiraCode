(ns fira-code.features
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [clojure.walk :as walk]
   [fira-code.glyphs :as glyphs]
   [fira-code.files :as files]))

;; Append calt feature code to the font's calt feature
(defn append-calt [font]
  (let [features (->> (files/find "features/calt" #"features/calt/[^/]+\.fea")
                      (map #(-> % slurp str/trim))
                      (str/join "\n\n"))]
    (prn "  appending to feature calt" (count (glyphs/lines features)) "lines")
    (glyphs/update-code font :features "calt" #(str % "\n\n" features))))

;; Fill a feature from a feature file
(defn fill-feature [font file]
  (let [[_ name]  (re-matches #"([^.]+)\.fea" (.getName file))
        code      (-> file slurp (walk/postwalk #(if (string? %) (str/trim %) %)))
        [_ notes code'] (re-matches #"(?s)#([^\n]+)\n(.*)" code)
        feature   (-> {:code (str/trim (or code' code)) :name name}
                      (when notes (assoc :notes (str/trim notes))))] ;; Only add notes key if notes are present
    (glyphs/set-feature font name feature)))

;; Fill all features of the font
(defn fill-features [font]
  (reduce fill-feature font (files/find "features" #"features/[^/]+\.fea")))

;; Fill all features and append calt code to the font
(defn fill-all [font]
  (-> font
    (append-calt)
    (fill-features)))
