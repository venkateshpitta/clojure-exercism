(ns etl)

(defn transform [dictionary]
  (reduce (fn [num [k v]]
            (reduce (fn [k1 v1] (assoc k1 (clojure.string/lower-case v1) k)) num v))
          {} dictionary))
