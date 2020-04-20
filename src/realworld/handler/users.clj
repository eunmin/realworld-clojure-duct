(ns realworld.handler.users
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]
            [realworld.auth :refer [login]]))

(defmethod ig/init-key :realworld.handler.users/login [_ options]
  (fn [{login-input :body-params :as req}]
    {:status 200
     :body {:user
            {:email "test@test.com"
             :token (login "jake@jake.jake")
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))

(defmethod ig/init-key :realworld.handler.users/registration [_ {:keys [db]}]
  (fn [{registration-input :body-params}]
    {:status 200
     :body {:user
            {:email "test@test.com"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))


