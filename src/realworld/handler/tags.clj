(ns realworld.handler.tags
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.tags/list-tag [_ options]
  (fn [{update-user-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))
