(ns say
  (:require [clojure.pprint]))

(defn number [given]
  (if (or (< given 0) (> given 999999999999))
    (throw (IllegalArgumentException. "IllegalArgumentException"))
    (clojure.string/replace (clojure.pprint/cl-format nil "~R" given)
                            "," "")))
