(ns perfect-numbers)

(defn- factor-list [num cur factors]
  (if (= num cur)
    (remove nil? factors)
    (recur num (+ 1 cur) (conj factors (if (zero? (mod num cur)) cur)))))

(defn- sum [xs]
  (reduce + xs))

(defn classify [num]
  (if (neg? num) (throw (IllegalArgumentException. "IllegalArgumentException")))
  (condp (fn [x y] (x (sum (factor-list num 1 [])) y)) num
    = :perfect
    > :abundant
    < :deficient))
