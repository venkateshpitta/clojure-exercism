(ns change)
;; pasted from github again..  how to solve this by hand, let alone
;; using Clojure?
(defn issue [sum coins]
  (when (or (neg? sum) (and (pos? sum) (every? #(< sum %) coins)))
    (throw (IllegalArgumentException. "cannot change")))
  (let [all-amounts (reduce (fn [cached-amounts amount]
                              (->> (sort coins)
                                   (filter #(<= % amount))
                                   (map #(conj (cached-amounts (- amount %) []) %))
                                   (apply min-key count)
                                   (assoc cached-amounts amount)))
                            {} (range 1 (inc sum)))]
    (all-amounts sum)))
