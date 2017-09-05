(ns hamming)

(defn distance [a b]
  (if (not (= (count a) (count b)))
    nil
    (if (> (count a) 0)
      (+ (if (= (first a) (first b)) 0 1) (distance (rest a) (rest b)))
      0)))
