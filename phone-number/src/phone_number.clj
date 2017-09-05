(ns phone-number)

(defn cleanse-number [pn]
  (clojure.string/replace pn #"[\(\)\ \-\.]" ""))


(defn number [pn]
  (let [pn-cleansed (cleanse-number pn)
        pn-length (count pn-cleansed)]
    (cond (or (< pn-length 10)
              (and (> pn-length 10)
                   (not (= \1 (get pn-cleansed 0))))) "0000000000"
          (= 10 pn-length) pn-cleansed
          :else (apply str (drop 1 pn)))))

(defn area-code [pn]
  (apply str (take 3 (number pn))))

(defn pretty-print [pn]
  (let [normalised-number (number pn)]
    (str "(" (area-code pn) ")"
         " "
         (apply str (take 3 (drop 3 normalised-number)))
         "-"
         (apply str (take-last 4 normalised-number)))))
