(ns fira-code.files
  (:refer-clojure :exclude [find])
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))


(defn find [path re]
  (->> (file-seq (io/file path))
    (next) ;; skip directory itself
    (filter #(re-matches re (.getPath %)))
    (sort-by #(.getPath %))))