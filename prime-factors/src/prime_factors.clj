(ns prime-factors)
(require 'clojure.math.numeric-tower)

(defn of [n]
  (loop [m n
         div 2
         acc []]
    (cond
      (zero? (mod m div)) (recur (/ m div)
                                 div
                                 (conj acc div))
      (< m 2) acc
      :else (recur m (if (odd? div)
                               (+ 2 div)
                               (inc div)) acc))))
