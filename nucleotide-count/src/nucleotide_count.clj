(ns nucleotide-count)

(defn count [n dna]
  (if (and (not (empty? dna))
           (not (.contains dna (str n))))
    (throw (Exception. "Invalid"))
    (get (frequencies dna) n 0)))

(defn nucleotide-counts [dna]
  (merge {\A 0, \C 0, \G 0, \T 0}
         (frequencies dna)))
