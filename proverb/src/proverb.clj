(ns proverb)

(def proverb
  (let [given ["nail" "shoe" "horse" "rider" "message" "battle" "kingdom"]
        final-3 (reverse (take 3 given))
        final-item (clojure.string/join " " [(clojure.string/join "" (take 2 final-3)) (last final-3)])
        poem-proverb (loop [current given
                            acc ""]
                            (if (<= (count current) 1)
                              (apply str (concat acc "\nAnd all for the want of a " final-item "."))
                              (recur (rest current)
                                     (clojure.string/join "\n"
                                                          [acc
                                                           (apply str
                                                                  (concat "For want of a "
                                                                          (first current)
                                                                          " the "
                                                                          (second current)
                                                                          " was lost."))]))))]
    (clojure.string/join "\n" (into [] (rest (clojure.string/split poem-proverb #"\n"))))))
