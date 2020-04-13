(ns realworld.dto
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]))

(s/def ::username string?)
(s/def ::email string?)
(s/def ::bio string?)
(s/def ::image string?)
(s/def ::password string?)

(s/def :login-input/user (s/keys :req-un [::email ::password]))
(s/def ::login-input (s/keys :req-un [:login-input/user]))

(s/def :registration-input/user (s/keys :req-un [::username ::email ::password]))
(s/def ::registration-input (s/keys :req-un [:registration-input/user]))

(s/def :update-user-input/user (s/keys :opt-un [::email ::username ::bio ::image]))
(s/def ::update-user-input (s/keys :req-un [:update-user-input/user]))

(defmethod ig/init-key :realworld.dto/load [_ options])
