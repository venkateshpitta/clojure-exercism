(ns octal)
(require 'clojure.math.numeric-tower)

(defn is-valid-octal [s]
  (not (empty? (re-matches (re-pattern "[0-7]*$") s))))

(defn to-decimal [s]
  (if (is-valid-octal s)
    (let [n (Integer/parseInt s)]
      (loop [cur n
             pos 0
             dec 0]
        (if (> cur 0)
          (recur (quot cur 10)
                 (inc pos)
                 (+ dec
                    (* (mod cur 10)
                       (clojure.math.numeric-tower/expt 8 pos))))
          dec)))
    0))
