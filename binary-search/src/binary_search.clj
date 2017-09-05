(ns binary-search)

(defn search-for [x xs]
  (let [idx (java.util.Collections/binarySearch xs x compare)]
    (cond
      (>= idx 0) idx
      :else (throw (Exception. "not found")))))

(defn middle [xs]
  (/ (count xs) 2))
