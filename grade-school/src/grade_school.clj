(ns grade-school)

(defn add [db student-name student-grade]
  (let [new-list (conj (get db student-grade []) student-name)]
    (assoc db student-grade new-list)))

(defn grade [db student-grade]
  (get db student-grade []))

(defn sorted [db]
  (let [sorted-keys (sort (keys db))]
    (zipmap sorted-keys
            (map (fn [w] (into [] (sort w)))
                 (map (fn [x] (get db x)) sorted-keys)))))
