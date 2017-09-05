(ns hexadecimal)
(require 'clojure.math.numeric-tower)

(defn hex-to-int [hex]
  (let [table {\0 0 \1 1 \2 2 \3 3
               \4 4 \5 5 \6 6 \7 7
               \8 8 \9 9 \a 10 \b 11
               \c 12 \d 13 \e 14 \f 15}
        r-hex (reverse (clojure.string/lower-case hex))
        is-valid-hex? (fn [s]
                        (every? (set (keys table)) s))]
    (if (is-valid-hex? hex)
      (reduce +'
              (map (fn [cur pos] (* (table cur)
                                    (clojure.math.numeric-tower/expt
                                     16 pos)))
                   r-hex
                   (range 0 (count r-hex))))
      0)))
