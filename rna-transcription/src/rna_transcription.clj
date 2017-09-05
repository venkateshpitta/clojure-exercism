(ns rna-transcription)

(defn to-rna [dna] ;; <- arglist goes here
  (let [table {\G "C", \C "G", \T "A", \A "U"}]
    (assert (every? #(contains? table %) dna))
    (apply str (map (fn [c] (table c)) (seq dna)))))
