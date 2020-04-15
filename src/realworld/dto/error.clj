(ns realworld.dto.error
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]))

(s/def ::body (s/coll-of string?))

(s/def ::errors (s/keys :req-un [::body]))

(defmethod ig/init-key ::require [_ _])
