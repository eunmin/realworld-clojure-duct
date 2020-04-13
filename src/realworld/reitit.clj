(ns realworld.reitit
  (:require [integrant.core :as ig]
            reitit.coercion.spec))

(defmethod ig/init-key :realworld.reitit/spec-coercion [_ options]
  reitit.coercion.spec/coercion)
