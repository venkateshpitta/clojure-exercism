(ns binary)
(require 'clojure.math.numeric-tower)

(defn to-decimal [bin-str]
  (defn helper [rb pos acc]
    (if (empty? rb)
      acc
      (condp = (first rb)
        \1 (recur (rest rb) (inc pos) (+ acc (clojure.math.numeric-tower/expt 2 pos)))
        \0 (recur (rest rb) (inc pos) acc)
        0)))
  (helper (reverse bin-str) 0 0))
