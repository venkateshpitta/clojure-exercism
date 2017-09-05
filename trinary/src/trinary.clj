(ns trinary)
(require 'clojure.math.numeric-tower)

(defn to-decimal [trin-string]
  (defn helper [given pos acc]
    (if (> given 0)
      (recur (quot given 10)
             (inc pos)
             (+ acc (* (mod given 10)
                       (clojure.math.numeric-tower/expt 3 pos))))
      acc))
  (if (not (empty?
            (drop-while #(Character/isDigit %)
                        trin-string)))
    0
    (helper (Integer/parseInt trin-string) 0 0)))
