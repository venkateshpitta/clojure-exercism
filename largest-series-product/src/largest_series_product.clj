(ns largest-series-product)

(defn segments [len digits]
  (map #(take len (drop % digits)) (range 0 (- (count digits) (dec len)))))

(defn segment-product [seg]
  (reduce * 1 (map #(Integer/parseInt %) (map str seg))))

(defn largest-product [len digits]
  (assert (not (neg? len)))
  (apply max (map segment-product (segments len digits))))

