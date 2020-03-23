(ns fira-code.time
  (:import
   [java.time LocalDateTime ZoneId]
   [java.time.format DateTimeFormatter]))


(def ^ZoneId UTC (ZoneId/of "UTC"))


(defn now-str []
  (.format
    (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss +0000")
    (LocalDateTime/now UTC)))
