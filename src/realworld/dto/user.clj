(ns realworld.dto.user
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]))

(s/def ::email string?)
(s/def ::token string?)
(s/def ::username string?)
(s/def ::bio string?)
(s/def ::image (s/nilable string?))
(s/def ::password string?)
(s/def ::following boolean?)

(s/def ::user
  (s/keys :req-un [::email
                   ::token
                   ::username
                   ::bio
                   ::image]))

(s/def ::profile
  (s/keys :req-un [::username
                   ::bio
                   ::image
                   ::following]))

(s/def :realworld.dto.user.login-input/user
  (s/keys :req-un [::email
                   ::password]))
(s/def ::login-input
  (s/keys :req-un [:realworld.dto.user.login-input/user]))

(s/def :realworld.dto.user.registration-input/user
  (s/keys :req-un [::username
                   ::email
                   ::password]))
(s/def ::registration-input
  (s/keys :req-un [:realworld.dto.user.registration-input/user]))

(s/def :realworld.dto.user.update-input/user
  (s/keys :opt-un [::email
                   ::username
                   ::password
                   ::image
                   ::bio]))
(s/def ::update-input
  (s/keys :opt-un [:realworld.dto.user.update-input/user]))

(defmethod ig/init-key ::require [_ _])
