(ns luhn)

(defn checksum [n]
  (let [fs (cycle [1 2])
        ns (map #(Character/digit % 10) (str n))
        ds (reduce + 0
                   (map #(+ (quot % 10) (mod % 10))
                        (map * (reverse ns) fs)))]
    (mod ds 10)))

(defn valid? [n]
  (zero? (checksum n)))

(defn check-digit [n]
  (let [cd (checksum (* 10 n))]
    (cond
      (zero? cd) cd
      :else (- 10 cd))))

(defn add-check-digit [n]
  (+ (* 10 n) (check-digit n)))
