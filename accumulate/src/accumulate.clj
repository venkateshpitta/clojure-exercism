(ns accumulate)

(defn accumulate [func coll]
  (lazy-seq (reduce #(conj %1 (func %2)) [] coll)))
