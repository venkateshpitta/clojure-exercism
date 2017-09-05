(ns queen-attack)
(require 'clojure.math.numeric-tower)

(defn board-string [queens]
  (defn blank-line []
    (str
     (clojure.string/trim
      (apply str (take 8 (repeat "_ "))))
     "\n"))
  (if (empty? queens)
    (clojure.string/join
     ""
     (take 8 (repeat (blank-line))))
    (let [[wx wy] (queens :w)
          [bx by] (queens :b)
          put-queen (defn put-queen [location color]
                      (apply str (clojure.string/trim
                                  (apply str (take location
                                                   (repeat "_ "))))
                             (str " " color " ")
                             (clojure.string/trim
                              (apply str (take (- 7 location)
                                               (repeat "_ "))))
                             "\n"))
          minx (min wx bx)
          maxx (max wx bx)
          eqxx (= wx bx)] ;; I am no chess expert to handle this yet
      (cond
        (= minx wx) (clojure.string/join
                      ""
                      (apply str
                             (apply str (take minx (repeat (blank-line))))
                             (apply str (put-queen wy \W))
                             (apply str (take (- maxx (dec minx) 2)
                                              (repeat (blank-line))))
                             (apply str (put-queen by \B))
                             (apply str (take (- 8 (inc maxx))
                                              (repeat (blank-line))))))
        (= maxx wx) (clojure.string/join
                     ""
                     (apply str
                            (apply str (take minx (repeat (blank-line))))
                            (apply str (put-queen by \B))
                            (apply str (take (- maxx (dec minx) 2)
                                             (repeat (blank-line))))
                            (apply str (put-queen wy \W))
                            (apply str (take (- 8 (inc maxx))
                                             (repeat (blank-line))))))
        :else nil))))

(defn can-attack [positions]
  (let [black (positions :b)
        white (positions :w)]
    (or (= (first black) (first white))
        (= (last black) (last white))
        (and (= (clojure.math.numeric-tower/abs (- (first black) (first white)))
                (clojure.math.numeric-tower/abs (- (last black) (last white))))))))
