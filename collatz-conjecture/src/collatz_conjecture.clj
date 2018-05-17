(ns collatz-conjecture)

(defn collatz [n]
  (defn helper [m ret]
    (if (<= m 0)
      (throw (IllegalArgumentException. "IllegalArgumentException"))
      (if (= m 1)
        ret
        (if (even? m)
          (helper (/ m 2) (inc ret))
          (helper (+ (* 3 m) 1) (inc ret))))))
  (helper n 0))
