(ns strain)

(defn retain1 [pred chain]
  (cond
    (empty? chain) []
    (pred (first chain)) (conj (retain1 pred (rest chain)) (first chain))
    :else (retain1 pred (rest chain))))

(defn retain [pred chain]
  (into [] (reverse (retain1 pred chain))))

(defn discard [pred chain]
  (retain (complement pred) chain))
