(ns fira-code.coll)


(defn index-of [pred xs]
  (let [res (reduce (fn [i x] (if (pred x) (reduced i) (inc i))) 0 xs)]
    (assert (< res (count xs)) "Nothing found")
    res))


(defn group-by-to [key-fn value-fn xs]
  (reduce-kv
    (fn [m k vs]
      (assoc m k (value-fn vs)))
    {}
    (group-by key-fn xs)))