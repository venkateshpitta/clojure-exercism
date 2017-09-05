(ns bracket-push)

(defn valid? [expr]
  (let [all {\} \{ \] \[ \) \( }
        opens (set (vals all))
        closes (set (keys all))]
    (loop [[one & many-more :as e] expr
           stack []]
      (cond (empty? e) (empty? stack)
            (opens one) (recur many-more (conj stack one))
            (closes one) (if (= (peek stack) (all one))
                           (recur many-more (pop stack))
                           false)
            :else (recur many-more stack)))))
