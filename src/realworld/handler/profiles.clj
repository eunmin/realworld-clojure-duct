(ns realworld.handler.profiles
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.profiles/get [_ options]
  (fn [_]
    {:status 200
     :body {:profile
            {:username "jake"
             :bio "I work at statefarm"
             :image "https://static.productionready.io/images/smiley-cyrus.jpg"
             :following false}}}))

(defmethod ig/init-key :realworld.handler.profiles/follow [_ options]
  (fn [_]
    {:status 200
     :body {:profile
            {:username "jake"
             :bio "I work at statefarm"
             :image "https://static.productionready.io/images/smiley-cyrus.jpg"
             :following false}}}))

(defmethod ig/init-key :realworld.handler.profiles/unfollow [_ options]
  (fn [_]
    {:status 200
     :body {:profile
            {:username "jake"
             :bio "I work at statefarm"
             :image "https://static.productionready.io/images/smiley-cyrus.jpg"
             :following false}}}))
