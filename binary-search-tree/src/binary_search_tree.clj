(ns binary-search-tree)

;; imitation is the highest form of flattery

(defn value [node]
  (:ele node))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn singleton [root]
  (hash-map :ele root))

(defn insert [value {:keys [ele left right] :as tree}]
  (cond
    (nil? tree)   (singleton value)
    (< ele value) (assoc tree :right (insert value right))
    :else         (assoc tree :left  (insert value left))))

(defn from-list [[fst & rst]]
  (reduce (fn [tree value] (insert value tree)) (singleton fst) rst))

(defn to-list [tree]
  (when tree
    (concat (to-list (left tree))
            (list    (value tree))
            (to-list (right tree)))))
