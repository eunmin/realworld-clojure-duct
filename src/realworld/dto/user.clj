(ns realworld.dto.user
  (:require [clojure.spec.alpha :as s]))

(s/def ::email string?)
(s/def ::password string?)
(s/def ::user (s/keys :req-un [::email ::password]))
(s/def ::user-input (s/keys :req-un [::user]))
