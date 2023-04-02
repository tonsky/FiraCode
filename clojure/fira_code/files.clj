(ns fira-code.files
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn- matches-re?
  "Returns true if the file name matches the given regular expression."
  [re file]
  (re-matches re (.getName file)))

(defn- matching-files
  "Returns a vector of files in the directory tree rooted at the given path
  that match the given regular expression."
  [path re]
  (->> (path-seq (io/file path))
       (filterv #(matches-re? re %))
       (sort-by #(.getPath %))))

