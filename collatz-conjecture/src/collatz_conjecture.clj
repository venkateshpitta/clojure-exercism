(ns collatz-conjecture)

(defn collatz [n]
  (defn helper [m ret]
    (if (<= m 0)
      (throw (IllegalArgumentException. "IllegalArgumentException"))
      (if (= m 1)
        ret
        (helper (if (even? m)
                  (/ m 2)
                  (+ (* 3 m) 1))
                (inc ret)))))
  (helper n 0))
