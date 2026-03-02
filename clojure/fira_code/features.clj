(ns fira-code.features
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]
   [fira-code.files :as files])
  (:import
   [java.io File]))

(defn trim [s]
  (-> s
    (str/replace #"(?m) +$" "")
    (str/trim)))

(defn append-calt [font]
  (let [features (->> (files/find "features/calt" #"features/calt/[^/]+\.fea")
                   (map slurp)
                   (map trim)
                   (str/join "\n\n"))]
    (println "  appending to feature calt" (glyphs/lines features) "lines")
    (glyphs/update-code font :features :tag "calt" #(str % "\n\n" features))))

(defn fill-feature [font file]
  (let [[_ tag]        (re-matches #"([^.]+)\.fea" (File/.getName file))
        code           (slurp file)
        [_ name code'] (re-matches #"(?s)###[ ]*([^\n]*[^\n ])[ ]*\n(.*)" code)
        code           (trim (or code' code))
        feature        (cond-> {:code code}
                         (and (str/starts-with? tag "ss") name)
                         (assoc :labels
                           [{:language "dflt"
                             :value    name}])
                         true (assoc :tag tag))]
    (glyphs/set-feature font tag feature)))

(defn fill-features [font]
  (reduce fill-feature font (files/find "features" #"features/[^/]+\.fea")))

(defn fill-all [font]
  (-> font
    (append-calt)
    (fill-features)))
