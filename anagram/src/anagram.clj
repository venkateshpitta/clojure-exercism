(ns anagram)

(defn anagrams-for [given-word candidates] ;; <- arglist goes here
  ;;
  (let [sorted-given-word (sort (clojure.string/lower-case given-word))]
    (filter (fn [x] (and (not (= (clojure.string/lower-case x) (clojure.string/lower-case given-word)))
                         (= sorted-given-word (sort (clojure.string/lower-case x)))))
            candidates)))
