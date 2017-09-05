(ns raindrops)

(defn convert [n]
  (let [pling (if (zero? (mod n 3)) "Pling")
        plang (if (zero? (mod n 5)) "Plang")
        plong (if (zero? (mod n 7)) "Plong")
        pass (if (and (not (zero? (mod n 3)))
                      (not (zero? (mod n 5)))
                      (not (zero? (mod n 7))))
               (str n))]
    (if (empty? pass)
      (str pling plang plong)
      pass)))
