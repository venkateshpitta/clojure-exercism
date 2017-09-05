(ns sieve)

;; sieve of eratosthenes
(defn sieve [n]
  (into []
        (loop [prime-nums []
               all-numbers (take (dec n) (iterate inc 2))]
          (if (empty? all-numbers)
            prime-nums
            (recur (conj prime-nums (first all-numbers))
                   (remove #(zero? (mod % (first all-numbers)))
                           all-numbers))))))
