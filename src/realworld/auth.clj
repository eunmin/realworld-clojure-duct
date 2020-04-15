(ns realworld.auth
  (:require [integrant.core :as ig]))

(def tokens {:2f904e245c1f5 :admin
             :45c1f5e3f05d0 :foouser})

(defmethod ig/init-key ::auth-fn [_ options]
  (fn [request token]
    (println token)
    (let [token (keyword token)]
      (get tokens token nil))))
