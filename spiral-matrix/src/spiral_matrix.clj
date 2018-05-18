(ns spiral-matrix)

(defn spiral [n]
  (defn rot90
    "Rotate rows 90 degrees clockwise."
    [rows]
    (mapv reverse (apply map list rows)))

  (defn add-row
    "Adds new row, values starting at bottom left value + 1."
    [rows]
    (let [n (-> rows last first dec)
          width (-> rows first count)
          row (take width (iterate dec n))]
      (conj rows row)))

  (if (zero? n)
    '()
    (let [seed [[(* n n)]]
          idx (* 2 (dec n))
          step (comp add-row rot90)]
      (-> (iterate step seed) (nth idx) rot90 rot90))))
