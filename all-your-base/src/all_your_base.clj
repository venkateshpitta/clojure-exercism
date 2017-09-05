(ns all-your-base)

;; solution adapted from accepted answer on
;; https://cs.stackexchange.com/questions/10318/the-math-behind-converting-from-any-base-to-any-base-without-going-through-base

(defn to-digits [num base]
  (loop [digits []
         cur num]
    (if (zero? cur)
      (if (empty? digits) '(0) digits)
      (recur (cons (mod cur base) digits)
             (quot cur base)))))

(defn from-digits [digits base]
  (loop [n 0
         d digits]
    (if (empty? d)
      n
      (recur (+ (first d) (* base n)) (rest d)))))

(defn convert [from-base digits to-base]
  (if (or (< from-base 2) (< to-base 2)
          (not (empty? (filter neg? digits)))
          (not (empty? (filter #(>= % from-base) digits))))
    nil
    (if (empty? digits)
      '()
      (to-digits (from-digits digits from-base) to-base))))
