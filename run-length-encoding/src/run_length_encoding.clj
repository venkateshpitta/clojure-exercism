(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (loop [code ""
         lst (partition-by identity s)]
    (if (empty? lst) code
        (recur (apply str (concat code
                                  (if (> (count (first lst)) 1)
                                    (str (count (first lst)))
                                    "")
                                  (str (first (set (first lst))))))
               (rest lst)))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (let [triples (re-seq #"(\d*)(\D)" s)
        numbers (map (fn [x] (if (empty? (x 1)) 1 (Integer/parseInt (x 1)))) triples)
        letters (map (fn [x] (x 2)) triples)]
    (clojure.string/join (map (fn [n l] (clojure.string/join (repeat n l))) numbers letters))))
