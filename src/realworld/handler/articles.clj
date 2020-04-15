(ns realworld.handler.articles
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.articles/list-article [_ options]
  (fn [{{:keys [tag author favorited limit offset]} :query-params}]
    {:status 200
     :body {:articles
            [{:slug "how-to-train-your-dragon"
              :title "How to train your dragon"
              :description "Ever wonder how?"
              :body "It takes a Jacobian"
              :tagList ["dragons", "training"]
              :createdAt "2016-02-18T03:22:56.637Z"
              :updatedAt "2016-02-18T03:48:35.824Z"
              :favorited false
              :favoritesCount 0
              :author {:username "jake"
                       :bio "I work at statefarm"
                       :image "https://i.stack.imgur.com/xHWG8.jpg"
                       :following false}}]}}))

(defmethod ig/init-key :realworld.handler.articles/feed [_ options]
  (fn [{{:keys [limit offset]} :query-params}]
    {:status 200
     :body {:articles
            [{:slug "how-to-train-your-dragon"
              :title "How to train your dragon"
              :description "Ever wonder how?"
              :body "It takes a Jacobian"
              :tagList ["dragons", "training"]
              :createdAt "2016-02-18T03:22:56.637Z"
              :updatedAt "2016-02-18T03:48:35.824Z"
              :favorited false
              :favoritesCount 0
              :author {:username "jake"
                       :bio "I work at statefarm"
                       :image "https://i.stack.imgur.com/xHWG8.jpg"
                       :following false}}]}}))

(defmethod ig/init-key :realworld.handler.articles/get-article [_ options]
  (fn [{{:keys [slug]} :path-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))

(defmethod ig/init-key :realworld.handler.articles/create [_ options]
  (fn [{article-create-input :body-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))

(defmethod ig/init-key :realworld.handler.articles/update-article [_ options]
  (fn [{article-update-input :body-params
        {:keys [slug]} :path-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))

(defmethod ig/init-key :realworld.handler.articles/delete-article [_ options]
  (fn [{{:keys [slug]} :path-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))

(defmethod ig/init-key :realworld.handler.articles/favorite [_ options]
  (fn [{{:keys [slug]} :path-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))

(defmethod ig/init-key :realworld.handler.articles/unfavorite [_ options]
  (fn [{{:keys [slug]} :path-params}]
    {:status 200
     :body {:article
            {:slug "how-to-train-your-dragon"
             :title "How to train your dragon"
             :description "Ever wonder how?"
             :body "It takes a Jacobian"
             :tagList ["dragons", "training"]
             :createdAt "2016-02-18T03:22:56.637Z"
             :updatedAt "2016-02-18T03:48:35.824Z"
             :favorited false
             :favoritesCount 0
             :author {:username "jake"
                      :bio "I work at statefarm"
                      :image "https://i.stack.imgur.com/xHWG8.jpg"
                      :following false}}}}))
