(ns fira-code.coll)


(defn index-of [pred xs]
  (let [res (reduce (fn [i x] (if (pred x) (reduced i) (inc i))) 0 xs)]
    (if (>= res (count xs))
      -1
      res)))


(defn group-by-to [key-fn value-fn xs]
  (reduce-kv
    (fn [m k vs]
      (assoc m k (value-fn vs)))
    {}
    (group-by key-fn xs)))


(defn multimap-by [f & kvs]
  (reduce
    (fn [m [k v]]
      (if (contains? m k)
        (update m k f v)
        (assoc m k v)))
    {} (partition 2 kvs)))