(ns realworld.domain.user
  (:require [clojure.spec.alpha :as s]))

(s/def ::email string?)
(s/def ::token string?)
(s/def ::username string?)
(s/def ::bio string?)
(s/def ::image (s/nilable string?))

(s/def ::user (s/keys :req-un [::email ::token ::username ::bio ::image]))
