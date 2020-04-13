(ns realworld.domain.article
  (:require [clojure.spec.alpha :as s]
            [realworld.domain.profile :as profile]))

(s/def ::slug string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::body string?)
(s/def ::tag-list (s/coll-of string?))
(s/def ::created-at string?)
(s/def ::updated-at string?)
(s/def ::favorited boolean?)
(s/def ::favorites-count integer?)
(s/def ::author ::profile/profile)

(s/def ::article (s/keys :req-un [::slug
                                  ::title
                                  ::description
                                  ::body
                                  ::tag-list
                                  ::created-at
                                  ::updated-at
                                  ::favorited
                                  ::favorites-count
                                  ::author]))
