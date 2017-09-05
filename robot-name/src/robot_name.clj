(ns robot-name)

(defn random-name []
  (let [alphas "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        name (str (rand-nth alphas)
                  (rand-nth alphas)
                  (format "%03d" (rand-int 999)))]
    name))

(defn robot []
  (atom (random-name)))

(defn robot-name [r]
  @r)

(defn reset-name [r]
  (reset! r (random-name)))

