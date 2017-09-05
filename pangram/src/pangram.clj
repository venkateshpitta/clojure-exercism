(ns pangram)

;; this fails 5 tests
;; (defn pangram? [p]
;;   (= 26
;;      (count
;;       (distinct
;;        (re-matches
;;         (re-pattern "[a-zA-Z]*$")
;;         (clojure.string/lower-case p))))))

;; this fails 7 tests
;; (defn pangram? [p]
;;   (= 26
;;      (count
;;       (into []
;;             (distinct
;;              (filter #(and (<= (compare \a %))
;;                            (<= (compare % \z)))
;;                      (map #(Character/toLowerCase %) p)))))))


;; this, from the github of course,  passes every test..
(defn- char<= [ch1 ch2] (<= (compare ch1 ch2) 0))

(defn pangram? [input]
  (->> input
       (into [] (comp (map #(Character/toLowerCase %))
                      (filter #(and (char<= \a %) (char<= % \z)))
                      (distinct)))
       count
       (= 26)))
;; how? why?
