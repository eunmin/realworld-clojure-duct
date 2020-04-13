(ns realworld.handler.user
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.user/current-user [_ options]
  (fn [_]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))

(defmethod ig/init-key :realworld.handler.user/update-user [_ options]
  (fn [{update-user-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))
