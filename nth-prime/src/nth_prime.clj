(ns nth-prime)

(defn is-prime [knowns n]
  (empty? (filter (fn [x] (and (<= x n)
                               (zero? (mod n x))))
                  knowns)))

(defn find-next-primes [primes]
  (concat primes
          (filter (fn [x] (is-prime primes x))
                  (range (last primes)
                         (* 2 (last primes))
                         2))))

(def get-next-prime (memoize find-next-primes))

(defn nth-prime [n]
  (cond
    (zero? n) (throw (IllegalArgumentException.))
    (= 1 n) 2
    (= 2 n) 3
    :else (loop [primes (get-next-prime [2 3])]
            (if (>= (count primes) n)
              (nth primes (dec n))
              (recur (get-next-prime primes))))))
