(ns isogram)

(defn isogram? [text]
  (let [cleansed (-> text
                     clojure.string/lower-case
                     (clojure.string/replace #"-| " ""))
        len-cleansed (count cleansed)]
    (= len-cleansed (-> cleansed
                        set
                        count))))
