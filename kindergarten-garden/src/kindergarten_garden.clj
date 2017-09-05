(ns kindergarten-garden)

(defn garden
  ([plants]
   (garden plants ["Alice" "Bob" "Charlie" "David"
                           "Eve" "Fred" "Ginny" "Harriet"
                           "Ileana" "Joseph" "Kincaid" "Larry"]))

  ([plants children]
   (let [child-keys (sort (map (comp keyword clojure.string/lower-case ) children))
         all-plants {\G :grass \C :clover \R :radishes \V :violets}
         lines (clojure.string/split-lines plants)
         twos (map (partial partition 2) lines)
         cups (apply map concat twos)
         cups (map (partial map all-plants) cups)
         pairs (map vector child-keys cups)]
     (reduce (partial apply assoc) {} pairs))))
