(ns realworld.dto.comment
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]
            [realworld.dto.article :as article]))

(s/def ::id integer?)
(s/def ::createdAt string?)
(s/def ::updatedAt string?)
(s/def ::body string?)

(s/def ::comment
  (s/keys :req-un [::id
                   ::createdAt
                   ::updatedAt
                   ::body
                   ::article/author]))

(s/def ::create-input
  (s/keys :req-un [::body]))

(s/def ::comments
  (s/coll-of ::comment))

(defmethod ig/init-key ::require [_ _])
