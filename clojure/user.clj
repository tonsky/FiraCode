(ns user
  (:require
   [clj-reload.core :as clj-reload]
   [clojure+.hashp :as hashp]
   [clojure+.print :as print]
   [clojure+.error :as error]))

(hashp/install!)
(print/install!)
(error/install!)

(clj-reload/init
  {:dirs      ["clojure"]
   :no-reload '#{user}})

(def reload
  clj-reload/reload)
