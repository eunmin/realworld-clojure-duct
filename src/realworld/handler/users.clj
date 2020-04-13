(ns realworld.handler.users
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.users/login [_ options]
  (fn [{login-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))


(defmethod ig/init-key :realworld.handler.users/registration [_ options]
  (fn [{registration-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))
