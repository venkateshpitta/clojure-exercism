(ns diamond)

(defn diamond [letter]
  (let [letters "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        longest (clojure.string/index-of letters (str letter))
        upper (take longest letters)
        lower (reverse upper)
        total (flatten (conj lower letter upper))
        length (count total)]
    (loop [all-letters total
           acc []]
      (if (empty? all-letters)
        acc
        (let [current (first all-letters)
              out-padding (- (clojure.string/index-of letters (str letter))
                             (clojure.string/index-of letters (str current)))
              in-padding (- length (* 2 out-padding) 2)
              out-spaces (clojure.string/join "" (repeat out-padding " "))
              in-spaces (clojure.string/join "" (repeat in-padding " "))
              line (if (= \A current)
                     (apply str (concat out-spaces "A" out-spaces))
                     (apply str (concat out-spaces
                                        (str current)
                                        in-spaces
                                        (str current)
                                        out-spaces)))]
          (recur (rest all-letters) (conj acc line)))))))
