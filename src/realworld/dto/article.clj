(ns realworld.dto.article
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]
            [realworld.dto.user :as user]))

(s/def ::slug string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::body string?)
(s/def ::tag string?)
(s/def ::tagList (s/coll-of ::tag))
(s/def ::createdAt string?)
(s/def ::updatedAt string?)
(s/def ::favorited boolean?)
(s/def ::favoritesCount integer?)
(s/def ::author ::user/profile)

(s/def ::article
  (s/keys :req-un [::slug
                   ::title
                   ::description
                   ::body
                   ::tagList
                   ::createdAt
                   ::updatedAt
                   ::favorited
                   ::favoritesCount
                   ::author]))

(s/def ::articles
  (s/coll-of ::article))

(s/def ::create-input
  (s/keys :req-un [::title
                   ::description
                   ::body]
          :opt-un [::tagList]))

(s/def ::update-input
  (s/keys :opt-un [::title
                   ::description
                   ::body]))

(s/def :realworld.dto.article.query/author string?)
(s/def :realworld.dto.article.query/favorited string?)
(s/def :realworld.dto.article.query/limit integer?)
(s/def :realworld.dto.article.query/offset integer?)

(s/def ::list-query
  (s/keys :req-un [::tag
                   :realworld.dto.article.query/author
                   :realworld.dto.article.query/favorited]
          :opt-un [:realworld.dto.article.query/limit
                   :realworld.dto.article.query/offset]))

(s/def ::feed-query
  (s/keys :opt-un [:realworld.dto.article.query/limit
                   :realworld.dto.article.query/offset]))

(defmethod ig/init-key ::require [_ _])
