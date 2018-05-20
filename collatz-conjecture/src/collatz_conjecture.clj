(ns collatz-conjecture)

(defn collatz [n]
  (loop [m n
         ret 0]
    (if (<= m 0)
      (throw (IllegalArgumentException. "IllegalArgumentException"))
      (if (= m 1)
        ret
        (recur (if (even? m)
                  (/ m 2)
                  (+ (* 3 m) 1))
                (inc ret))))))
