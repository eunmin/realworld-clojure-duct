(ns realworld.dto.profile
  (:require [clojure.spec.alpha :as s]
            [realworld.dto.user :as user]))

(s/def ::profile (s/keys :req-un [::user/username
                                  ::user/bio
                                  ::user/image
                                  ::user/following]))
