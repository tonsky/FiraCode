(ns fira-code.time
  (:import
   [java.time.LocalDateTime ZoneId]
   [java.time.format.DateTimeFormatter]))

(defn current-time-str
  "Returns a string representation of the current UTC time, in the format 'yyyy-MM-dd HH:mm:ss +0000'.
   Optional `time-zone` argument can be provided to use a different time zone."
  [& {:keys [time-zone] :or {time-zone ZoneId/UTC}}]
  (.format
    (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss Z")
    (LocalDateTime/now time-zone))))
