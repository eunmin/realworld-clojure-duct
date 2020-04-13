(ns realworld.domain.profile
  (:require [clojure.spec.alpha :as s]))

(s/def ::username string?)
(s/def ::bio string?)
(s/def ::image string?)
(s/def ::following boolean?)

(s/def ::profile (s/keys :req-un [::username ::bio ::image ::following]))
