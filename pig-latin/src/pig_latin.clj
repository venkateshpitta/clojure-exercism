(ns pig-latin)

(defn process-word [given]
  (let [normal-vowels ["a" "e" "i" "o" "u"]
        cluster-vowel ["yt" "xr"]
        twos-prefix ["ch" "qu" "th"]
        threes-prefix ["thr" "sch"]
        pfn (partial clojure.string/starts-with? given)
        ay-ed #(str % "ay")]
    (cond
      (or (some pfn normal-vowels)
          (some pfn cluster-vowel))
      (ay-ed given)

      (or (some pfn threes-prefix)
          (and (clojure.string/starts-with? (subs given 1) "qu")
               (not (some pfn normal-vowels))))
      (ay-ed (str (subs given 3) (subs given 0 3)))
      
      (some pfn twos-prefix)
      (ay-ed (str (subs given 2) (subs given 0 2)))

      :else
      (ay-ed (str (subs given 1) (subs given 0 1))))))
    
(defn translate [sentence]
  (->> (clojure.string/split sentence #" ")
       (map process-word)
       (clojure.string/join " ")))
