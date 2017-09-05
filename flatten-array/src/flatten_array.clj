(ns flatten-array)

(defn flatten [arr]
  (into [] (remove nil? (clojure.core/flatten arr))))
