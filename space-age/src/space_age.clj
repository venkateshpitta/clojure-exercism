(ns space-age)

(defn on-earth [seconds]
  (/ seconds 31557600))

(defn times-earth [seconds times]
  (/ (on-earth seconds) times))

(defn on-mercury [seconds]
  (times-earth seconds 0.2408467))

(defn on-venus [seconds]
  (times-earth seconds 0.61519726))

(defn on-mars [seconds]
  (times-earth seconds 1.8808158))

(defn on-jupiter [seconds]
  (times-earth seconds 11.862615))

(defn on-saturn [seconds]
  (times-earth seconds 29.447498))

(defn on-uranus [seconds]
  (times-earth seconds 84.016846))

(defn on-neptune [seconds]
  (times-earth seconds 164.79132))
