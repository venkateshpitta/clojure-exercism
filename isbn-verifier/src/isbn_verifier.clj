(ns isbn-verifier)

(defn isbn? [isbn]
  (let [given (clojure.string/replace isbn "-" "")
        final (get given (dec (count given)))]
    (and (= (count given)
            (count (.replaceAll given "[^0-9Xx]" "")))
         (.contains [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \x \X] final)
         (every? (fn [x] (or (= \0 x) (= \1 x) (= \2 x) (= \3 x) (= \4 x) (= \5 x)
                             (= \6 x) (= \7 x) (= \8 x) (= \9 x)))
                 (rest (clojure.string/reverse given)))
         (zero? (mod (reduce + (map (fn [x y] (* x (Integer/parseUnsignedInt y)))
                                    (range 10 0 -1)
                                    (map (fn [x] (if (= x "X") "10" x))
                                         (clojure.string/split given #""))))
                     11)))))
