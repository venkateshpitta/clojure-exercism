(ns difference-of-squares)

(defn square-of-sums [num]
  (let [sum (reduce +' 0 (range 0 (inc num)))]
    (*' sum sum)))

(defn sum-of-squares [num]
  (reduce +' 0 (map #(* % %) (range 1 (inc num)))))

(defn difference [num]
  (- (square-of-sums num) (sum-of-squares num)))
