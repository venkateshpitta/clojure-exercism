(ns acronym)

(defn acronym [name]
  (->> (re-seq #"[a-z]+|[A-Z]+[a-z]*" name)
       (map first)
       (apply str)
       clojure.string/upper-case))
