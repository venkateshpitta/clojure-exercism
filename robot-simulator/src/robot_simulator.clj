(ns robot-simulator)

(defn robot [xyz dir]
  {:coordinates xyz
   :bearing dir})

(def turn-right {:east :south
                 :west :north
                 :north :east
                 :south :west})
  
(def turn-left {:east :north
                :west :south
                :north :west
                :south :east})

(defn move-one-step [rob]
  (let [{x :x y :y} (rob :coordinates)]
    (case (rob :bearing)
      :north (assoc rob :coordinates {:x x :y (inc y)})
      :east  (assoc rob :coordinates {:x (inc x) :y y})
      :south (assoc rob :coordinates {:x x :y (dec y)})
      :west  (assoc rob :coordinates {:x (dec x) :y y}))))

(defn simulate [dirns rob]
  (loop [ins dirns
         cur rob]
    (if (empty? ins)
      cur
      (recur (rest ins)
             (case (first ins)
               \A (move-one-step cur)
               \L (assoc cur :bearing (turn-left (cur :bearing)))
               \R (assoc cur :bearing (turn-right (cur :bearing))))))))
