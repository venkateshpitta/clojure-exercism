(ns leap)

(defn leap-year? [n]
  (let [nmodx (fn [x] (= 0 (mod n x)))]
    (or (and (not (nmodx 100))
             (nmodx 4))
        (nmodx 400))))
