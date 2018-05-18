(ns rotational-cipher)

(defn rotate [text dist]
  (let [lower "abcdefghijklmnopqrstuvwxyz"
        upper "ABCDEFGHIJKLMNOPQRSTUVWXYZ"]
    (defn calculate-new-position [begin]
      (mod (+ begin dist) 26))
    (defn helper [runner acc]
      (if (empty? runner)
        acc
        (helper (rest runner)
                (apply str (concat acc
                                   (str (if (Character/isLetter (first runner))
                                          (if (Character/isLowerCase (first runner))
                                            (get lower (calculate-new-position
                                                        (clojure.string/index-of lower (first runner))))
                                            (get upper (calculate-new-position
                                                        (clojure.string/index-of upper (first runner)))))
                                          (first runner))))))))
    (apply str (helper text ""))))
