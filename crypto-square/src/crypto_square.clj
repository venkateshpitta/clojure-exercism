(ns crypto-square)
(require 'clojure.math.numeric-tower)

(defn normalize-plaintext [s]
  (clojure.string/lower-case
   (apply str
          (filter (fn [x] (or (Character/isLetter x)
                              (Character/isDigit x)))
                  s))))


(defn square-size [s]
  (int
   (clojure.math.numeric-tower/ceil
    (clojure.math.numeric-tower/sqrt
     (count (normalize-plaintext s))))))

(defn plaintext-segments [s]
  (let [normalized (normalize-plaintext s)
        boundary (square-size s)]
    (loop [remaining normalized
           acc []]
      (cond
        (empty? remaining) acc
        (>= boundary (count remaining)) (recur "" (conj acc remaining))
        :else (recur (subs remaining boundary)
                     (conj acc (subs remaining 0 boundary)))))))

(defn helper [s]
  (let [segments (plaintext-segments s)
        longest (square-size s)]
    (loop [index 0
           acc []]
      (if (= index longest)
        acc
        (recur (inc index)
               (conj acc
                     (apply str
                            (map #(if (< index (count %)) (nth % index))
                                 segments))))))))

(defn ciphertext [s]
  (clojure.string/join "" (helper s)))

(defn normalize-ciphertext [s]
  (clojure.string/join " " (helper s)))
