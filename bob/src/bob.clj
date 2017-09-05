(ns bob)

(defn response-for
  [input] (if (empty? (clojure.string/trim input)) "Fine. Be that way!"
            (if (= (clojure.string/lower-case input)
                 (clojure.string/upper-case input))
	      (if (clojure.string/ends-with? input "?")
	          "Sure."
		  "Whatever.")
	      (if (= input (clojure.string/upper-case input))
	        "Whoa, chill out!"
		(if (clojure.string/ends-with? input "?")
		  "Sure."
		  "Whatever.")))))
