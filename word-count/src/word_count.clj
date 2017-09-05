(ns word-count)

(defn word-count [given] ;; <- arglist goes here
  ;;
  (dissoc 
   (frequencies (clojure.string/split
                 (clojure.string/lower-case
                  (apply str (remove #((set ",.;:'!@$%&^-") %) given))) #" "))
   ""))
