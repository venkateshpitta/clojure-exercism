(ns collatz-conjecture)

(defn collatz [n]
  (loop [m n
         ret 0]
    (cond
      (<= m 0) (throw (IllegalArgumentException. ""))
      (= m 1) ret
      :else (recur (if (even? m)
                     (/ m 2)
                     (+ (* 3 m) 1))
                   (inc ret)))))
