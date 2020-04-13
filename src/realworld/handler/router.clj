(ns realworld.handler.router
  (:require [integrant.core :as ig]
            [realworld.util :refer [router-option]]
            [reitit.ring :refer [ring-handler router]]))

(defmethod ig/init-key :realworld.handler/router [_ options]
  (ring-handler (router options router-option)))
