(ns clock)

(defn clock [hour minute]
  (let [mquot (quot minute 60)
        mrem  (rem minute 60)
        
        h (rem (+ hour mquot) 24)
        hh (if (neg? h) (+ 24 h) h)
        mm (if (neg? mrem) (+ 60 mrem) mrem)
        hhh (if (neg? minute) (dec hh) hh)
        hhhh (if (neg? hhh) (+ 24 hhh) hhh)]
    [hhhh mm]))

(defn clock->string [clk]
  (format "%02d:%02d" (first clk) (second clk)))

(defn add-time [clk offset]
  (clock (first clk) (+ (second clk) offset)))
