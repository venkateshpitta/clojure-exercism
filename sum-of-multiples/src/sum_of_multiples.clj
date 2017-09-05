(ns sum-of-multiples)
(require 'clojure.set)

(defn multiples-of [m n]
  (take-while #(< % n) (iterate (partial + m) 0)))

(defn sum-of-multiples [ms n]
  (reduce + 0 (into #{}
                    (reduce clojure.set/union
                            '()
                            (map #(multiples-of % n) ms)))))
;; (ns sum-of-multiples) ;; defndaines

;; (def whole? (complement ratio?))

;; (defn sum-of-multiples
;;   ([x] (sum-of-multiples [3 5] x))
;;   ([of x]
;;    (let [pred (apply some-fn (map (fn [d] (fn [n] (whole? (/ n d)))) of))]
;;      (reduce + (filter pred (range 2 x))))))
