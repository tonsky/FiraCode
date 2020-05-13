(ns fira-code.features
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [fira-code.glyphs :as glyphs]
   [fira-code.files :as files]))


(defn append-calt [font]
  (let [features (->> (files/find "features/calt" #"features/calt/[^/]+\.fea")
                   (map slurp)
                   (map str/trim)
                   (str/join "\n\n"))]
    (println "  appending to feature calt" (glyphs/lines features) "lines")
    (glyphs/update-code font :features "calt"
      #(str % "\n\n" features))))


(defn fill-feature [font file]
  (let [[_ name]  (re-matches #"([^.]+)\.fea" (.getName file))
        code      (slurp file)
        [_ notes code'] (re-matches #"(?s)#([^\n]+)\n(.*)" code)
        feature   (if notes
                    {:code  (str/trim code')
                     :name  name
                     :notes (str/trim notes)}
                    {:code  (str/trim code)
                     :name  name})]
    (glyphs/set-feature font name feature)))


(defn fill-features [font]
  (reduce fill-feature font (files/find "features" #"features/[^/]+\.fea")))


(defn fill-all [font]
  (-> font
    (append-calt)
    (fill-features)))