(ns pascals-triangle)
(require 'clojure.math.numeric-tower)

(defn factorial [n]
  (reduce *' (range 1 (inc (clojure.math.numeric-tower/abs n)))))

(defn pascal-element [n r]
  ;; row n, col r
  (/ (factorial n)
     (* (factorial r) (factorial (- n r)))))

(defn row [n]
  ;; nth row has n cols
  (into [] (map #(pascal-element (dec n) %) (range 0 n))))

(def triangle (map row (iterate inc 1)))

