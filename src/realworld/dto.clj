(ns realworld.dto
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]))

(s/def ::username string?)
(s/def ::email string?)
(s/def ::token string?)
(s/def ::bio string?)
(s/def ::image (s/nilable string?))
(s/def ::password string?)
(s/def ::following boolean?)

(s/def :login-input/user (s/keys :req-un [::email ::password]))
(s/def ::login-input (s/keys :req-un [:login-input/user]))

(s/def :registration-input/user (s/keys :req-un [::username ::email ::password]))
(s/def ::registration-input (s/keys :req-un [:registration-input/user]))

(s/def :update-user-input/user (s/keys :opt-un [::email ::username ::bio ::image]))
(s/def ::update-user-input (s/keys :req-un [:update-user-input/user]))

(s/def ::user-payload (s/keys :req-un [::email ::token ::username ::bio ::image]))

(s/def ::profile-payload (s/keys :req-un [::username ::bio ::image ::following]))


(s/def ::tag string?)
(s/def :query/author string?)
(s/def ::favorited string?)
(s/def ::limit int?)
(s/def ::offset int?)

(s/def ::article-list-query (s/keys :req-un [::tag :query/author ::favorited]
                                    :opt-un [::limit ::offset]))

(s/def ::article-feed-query (s/keys :opt-un [::limit ::offset]))


(s/def ::slug string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::body string?)
(s/def ::tag-list (s/coll-of string?))
(s/def ::created-at string?)
(s/def ::updated-at string?)
(s/def ::favorited boolean?)
(s/def ::favorites-count integer?)
(s/def ::author ::profile-payload)

(s/def ::article-payload (s/keys :req-un [::slug
                                          ::title
                                          ::description
                                          ::body
                                          ::tag-list
                                          ::created-at
                                          ::updated-at
                                          ::favorited
                                          ::favorites-count
                                          ::author]))

(s/def ::article-list-payload (s/coll-of ::article-payload))

(defmethod ig/init-key :realworld.dto/load [_ options])
