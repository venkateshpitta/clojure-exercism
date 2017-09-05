(ns gigasecond)
(require 'clj-time.core)
(require 'clj-time.coerce)

(defn from [yyyy mm dd]
  (let [giga-moment (clj-time.core/plus
                     (clj-time.core/date-time yyyy mm dd)
                     (clj-time.core/seconds 1000000000))]
    [(clj-time.core/year giga-moment)
     (clj-time.core/month giga-moment)
     (clj-time.core/day giga-moment)]))
