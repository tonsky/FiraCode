(ns fira-code.coll
  (:require
   [clojure.string :as str]))

(defn index-of [pred xs]
  "Returns the index of the first element in xs that satisfies the predicate pred,
  or nil if no such element is found."
  (let [res (reduce (fn [i x] (if (pred x) (reduced i) (inc i))) 0 xs)]
    (if (>= res (count xs))
      nil
      res)))

(defn group-by-to [key-fn value-fn xs]
  "Groups the elements in xs by applying the key function key-fn to each element,
  and applies the value function value-fn to the resulting groups.
  Returns a map of the form {k (value-fn vs)} where k is the result of applying
  key-fn to a group of elements vs."
  (->> xs
       (group-by key-fn)
       (reduce-kv (fn [m k vs]
                    (assoc m k (value-fn vs))))))

(defn multimap-by [f & kvs]
  "Constructs a multimap by repeatedly applying the function f to a sequence of
  key-value pairs. Returns a map where each key can have multiple values."
  (reduce (fn [m [k v]]
            (update m k f v))
          {} kvs))
