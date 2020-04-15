(ns realworld.handler.comments
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.comments/list-comment [_ options]
  (fn [{update-user-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))

(defmethod ig/init-key :realworld.handler.comments/add-comment [_ options]
  (fn [{update-user-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))

(defmethod ig/init-key :realworld.handler.comments/delete-comment [_ options]
  (fn [{update-user-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))
