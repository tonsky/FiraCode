(ns fira-code.features
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]))


(defn append-features [font]
  (let [features (->> (file-seq (io/file "features"))
                   (filter #(str/ends-with? (.getName %) ".fea"))
                   (sort-by #(.getName %))
                   (map slurp)
                   (map str/trim)
                   (str/join "\n\n"))]
    (glyphs/update-code font :features "calt"
      #(str % "\n\n" features))))