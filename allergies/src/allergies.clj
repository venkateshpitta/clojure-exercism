(ns allergies)

(defn allergies [n]
  (let [table {1 :eggs
               2 :peanuts
               4 :shellfish
               8 :strawberries
               16 :tomatoes
               32 :chocolate
               64 :pollen
               128 :cats}]
    (defn helper [n i all]
      (if (> i 128)
        all
        (if (not (zero? (bit-and n i)))
          (recur n (* 2 i) (conj all (table i)))
          (recur n (* 2 i) all))))
    (helper n 1 [])))

(defn allergic-to? [n allergen]
  (let [table {:eggs 1 
               :peanuts 2 
               :shellfish 4 
               :strawberries 8 
               :tomatoes 16 
               :chocolate 32 
               :pollen 64 
               :cats 128}]
    (not (zero? (bit-and n (table allergen))))))
