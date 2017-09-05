(ns grains)
(require 'clojure.math.numeric-tower)

(defn square [n]
  (clojure.math.numeric-tower/expt 2 (dec n)))

(defn total []
  (reduce + 1 (map (fn [p] (clojure.math.numeric-tower/expt 2 p)) (range 1 64))))
