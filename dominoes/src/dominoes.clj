(ns dominoes
  (:require [clojure.math.combinatorics]))

(defn fetch-pairs-to-verify [stones]
  (loop [tiles stones
         acc []]
    (if (<= (count tiles) 1)
      acc
      (recur (rest tiles) (conj acc [(last (first tiles)) (first (second tiles))])))))

(defn is-chain? [potential]
  ;; (println "potential = " potential)
  (let [pairs (conj (fetch-pairs-to-verify potential)
                    [(first (first potential)) (last (last potential))])]
    (if (= 2 (count potential))
      (not (= (first potential) (second potential)))
      (every? (fn [pair] (= (first pair) (second pair))) pairs))))

(defn can-chain? [dominos]
  (if (= 1 (count dominos))
    (= (first (first dominos)) (second (first dominos)))
    (let [reversed (into [] (map #(into [] (reverse %)) dominos))
          complete (loop [run reversed
                          acc dominos]
                     (if (empty? run)
                       acc
                       (recur (rest run) (conj acc (first run)))))
          potentials (clojure.math.combinatorics/combinations complete (count dominos))]
      ;; (println "all potentials = " potentials "\nall potentials count = " (count potentials))
      (loop [run potentials]
        (cond
          (empty? run) false
          (is-chain? (first run)) true
          (= 2 (count (first run))) (and (not (= (first (first run))
                                                 (second (first run))))
                                         (is-chain? (first run)))
          :else (recur (rest run)))))))
