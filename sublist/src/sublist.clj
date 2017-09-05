(ns sublist)

(defn classify [a b]
  (let [join clojure.string/join
        as (join "_" a)
        bs (join "_" b)
        includes? clojure.string/includes?]
    (cond
      (= as bs) :equal
      (includes? as bs) :superlist
      (includes? bs as) :sublist
      :else :unequal)))
