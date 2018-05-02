(ns armstrong-numbers)
(require 'clojure.math.numeric-tower)

(defn armstrong? [n]
  (defn to-digits [given]
    (loop [num given
           acc []]
      (if (zero? num) acc
          (recur (quot num 10) (conj acc (mod num 10))))))
  (let [ds (to-digits n)
        sz (count ds)
        raised (map (fn [x] (clojure.math.numeric-tower/expt x sz)) ds)]
    (= n (reduce + raised))))
