(ns fira-code.classes
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]
   [fira-code.files :as files]))

(defn fill-class [font file]
  (let [filename (.getName file)
        class-name (->> filename
                      (re-find #"classes/([^/]+)\.fea$")
                      (second))
        class-code (str/trim (slurp file))
        class {:name class-name
               :code class-code}]
    (glyphs/set-class font class-name class)))

(defn fill-all [font]
  (let [class-files (files/find "classes" #"classes/[^/]+\.fea$")]
    (doseq [file class-files]
      (try
        (fill-class font file)
        (catch Exception e
          (println (str "ERROR: Could not fill class from file " (.getPath file) ": " e)))))
    font))
