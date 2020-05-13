(ns fira-code.classes
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]
   [fira-code.files :as files]))


(defn fill-class [font file]
  (let [[_ name] (re-matches #"([^.]+)\.fea" (.getName file))
        code     (slurp file)
        class    {:code (str/trim code)
                  :name name}]
    (glyphs/set-class font name class)))


(defn fill-all [font]
  (reduce fill-class font (files/find "classes" #"classes/[^/]+\.fea")))
