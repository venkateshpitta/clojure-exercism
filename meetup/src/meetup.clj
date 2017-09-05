(ns meetup)
(require 'clj-time.core)
(require 'clj-time.predicates)

(defn meetup [m yyyy day-of-the-week position]
  (let [first-week (map (fn [n] (clj-time.core/date-time yyyy m n))
                        (range 1 8))
        day-number (condp = day-of-the-week
                     :monday 1
                     :tuesday 2
                     :wednesday 3
                     :thursday 4
                     :friday 5
                     :saturday 6
                     :sunday 7)
        target-date (let [temp-date (first (filter (fn [d] (= day-number
                                                              (clj-time.core/day-of-week d)))
                                                   first-week))]
                     (condp = position
                      :first temp-date
                      :second (clj-time.core/plus
                               temp-date
                               (clj-time.core/weeks 1))
                      :third (clj-time.core/plus
                               temp-date
                               (clj-time.core/weeks 2))
                      :fourth (clj-time.core/plus
                               temp-date
                               (clj-time.core/weeks 3))
                      :teenth (let [teen-date (clj-time.core/plus
                                               temp-date
                                               (clj-time.core/weeks 1))]
                                (if (and
                                     (<= 13 (clj-time.core/day teen-date))
                                     (>= 19 (clj-time.core/day teen-date)))
                                  teen-date
                                  (clj-time.core/plus
                                   teen-date
                                   (clj-time.core/weeks 1))))
                      :last (let [last-date (clj-time.core/plus
                                             temp-date
                                             (clj-time.core/weeks 3))
                                  last-dates-month (clj-time.core/month last-date)
                                  last-dates-next-week (clj-time.core/plus
                                                       last-date
                                                       (clj-time.core/weeks 1))]
                              (if (= last-dates-month
                                     (clj-time.core/month last-dates-next-week))
                                last-dates-next-week
                                last-date))))]
    [(clj-time.core/year target-date)
     (clj-time.core/month target-date)
     (clj-time.core/day target-date)]))
