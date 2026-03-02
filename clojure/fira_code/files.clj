(ns fira-code.files
  (:refer-clojure :exclude [find])
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [java.io File]))

(defn find [path re]
  (->> (file-seq (io/file path))
    (next) ;; skip directory itself
    (filter #(re-matches re (File/.getPath %)))
    (sort-by File/.getPath)))
