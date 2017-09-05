(ns secret-handshake)

(defn commands [n]
  (defn helper [x]
    (= x (bit-and x n)))
  (let [l1 (conj []
                 (if (helper 1) "wink")
                 (if (helper 2) "double blink")
                 (if (helper 4) "close your eyes")
                 (if (helper 8) "jump"))
        l2 (if (helper 16) (reverse l1) l1)
        l3 (into [] (filter #(not (nil? %1)) l2))]
    l3))
