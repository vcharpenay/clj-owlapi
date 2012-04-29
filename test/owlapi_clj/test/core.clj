(ns owlapi-clj.test.core
  (:use [owlapi-clj.core])
  (:use [clojure.test])
  (:import (java.io File)))

(defn load-pizza 
	[] (load-ontology "http://www.co-ode.org/ontologies/pizza/pizza.owl"))

(deftest load-pizza-owl
  (is (load-pizza)))

(deftest load-then-remove-pizza-owl
  (is (not (remove-ontology! (load-pizza)))))

(deftest save-pizza
  (def file (doto (File/createTempFile "pizza" ".owl") (.delete) (.deleteOnExit)))
  (is (not (.exists file)))
  (save-ontology (load-pizza) file)
  (is (.exists file))
)

