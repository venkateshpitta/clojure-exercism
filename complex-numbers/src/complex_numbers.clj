(ns complex-numbers
  (:require [clojure.math.numeric-tower]))

(defn real [[a b]]
  a)

(defn imaginary [[a b]]
  b)

(defn abs [[a b]]
  (float (clojure.math.numeric-tower/sqrt
          (+ (* a a) (* b b)))))

(defn conjugate [[a b]]
  [a (* b -1)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))])

(defn div [[a b] [c d]]
  (let [den (+ (* c c 1.0) (* d d))]
    [(/ (+ (* a c) (* b d)) den)
     (/ (- (* b c) (* a d)) den)]))
