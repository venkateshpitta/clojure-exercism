(ns atbash-cipher)

(defn encode [given-string]
  (let [table {\a "z" \b "y"
               \c "x" \d "w"
               \e "v" \f "u"
               \g "t" \h "s"
               \i "r" \j "q"
               \k "p" \l "o"
               \m "n" \n "m"
               \o "l" \p "k"
               \q "j" \r "i"
               \s "h" \t "g"
               \u "f" \v "e"
               \w "d" \x "c"
               \y "b" \z "a"}
        converted (map (fn [x] (if (Character/isDigit x) x (table x)))
                       (clojure.string/lower-case
                        (clojure.string/replace given-string
                                                (re-pattern "[,.;\\s+]")
                                                "")))
        temp1 (loop [s converted
                     t []]
                (if (< (count s) 5)
                  (conj t s)
                  (recur (last (split-at 5 s))
                         (conj t (first (split-at 5 s))))))
        temp2 (map (fn [x] (apply str x)) temp1)]
    (clojure.string/trim
     (clojure.string/join " " temp2))))
