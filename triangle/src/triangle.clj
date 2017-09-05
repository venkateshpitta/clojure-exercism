(ns triangle)

(defn type [a b c]
  (let [longest-side (max a b c)
        [x y z] (sort [a b c])]
    (cond
      (>= longest-side (- (+ a b c) longest-side)) :illogical
      (= a b c) :equilateral
      (or (= x y) (= y z)) :isosceles
      :else :scalene)))
