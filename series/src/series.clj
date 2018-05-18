(ns series)

(defn slices [string n]
  (cond
    (empty? string) []
    (zero? n) [""]
    (> n (count string)) []
    (= n (count string)) [string]
    :else (loop [given string
                 acc []]
            (if (<= (count given) n)
              (conj acc given)
              (recur (apply str (drop 1 given))
                     (conj acc (apply str (take 3 given))))))))
