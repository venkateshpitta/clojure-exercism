(ns protein-translation)

(defn translate-codon [codon]
  (cond
    (= codon "AUG") "Methionine"
    (= codon "UGG") "Tryptophan"
    (or (= codon "UUU") (= codon "UUC")) "Phenylalanine"
    (or (= codon "UUA") (= codon "UUG")) "Leucine"
    (or (= codon "UCU") (= codon "UCC") (= codon "UCA") (= codon "UCG")) "Serine"
    (or (= codon "UAU") (= codon "UAC")) "Tyrosine"
    (or (= codon "UGU") (= codon "UGC")) "Cysteine"
    (or (= codon "UAA") (= codon "UAG") (= codon "UGA")) "STOP"))

(defn translate-rna [rna]
  (loop [running rna
         acc []]
    (if (or (empty? running)
            (= "STOP" (translate-codon (apply str (take 3 running)))))
      acc
      (recur (apply str (drop 3 running))
             (conj acc (translate-codon (apply str (take 3 running))))))))
