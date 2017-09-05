(ns beer-song)

(defn bottles-str [n]
  (str
   (cond
     (= 0 n) "no more bottles"
     (= 1 n) "1 bottle"
     :else (format "%d bottles" n))
   " of beer"))

(defn final-verse []
  (str "No more bottles of beer on the wall, no more bottles of beer."
       "\n"
       "Go to the store and buy some more, " (bottles-str 99) " on the wall."
       "\n"))

(defn verse [n]
  (if (= 0 n)
    (final-verse)
    (str (format "%s on the wall, %s." (bottles-str n) (bottles-str n))
         "\n"
         "Take " (if (= n 1) "it" "one") " down and pass it around, " (bottles-str (dec n)) " on the wall."
         "\n")))


;; (defn sing
;;   ([] (dorun (map (fn [x] (str (verse x) (if (> x 0) "\n"))) (range 99 -1 -1)) (final-verse)))
;;   ([n] (dorun (map (fn [x] (str (verse x) (if (> x 0) "\n"))) (range n -1 -1)) (final-verse)))
;;   ([m n] (dorun (map (fn [x] (str (verse x) (if (> x m) "\n"))) (range n (dec m) -1)))))
(defn sing [n & [m]]
  (dorun (map verse (reverse (range (if (and (integer? m) (< m n)) m 1) (inc n)))))
  (str "No more bottles of beer on the wall, no more bottles of beer.""\n"
       "Go to the store and buy some more," (verse n) "on the wall.""\n"))
