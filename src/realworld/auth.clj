(ns realworld.auth
  (:require [integrant.core :as ig]
            [ring.util.response :refer [response]]
            [clj-time.core :as time]
            [buddy.sign.jwt :as jwt]
            [buddy.auth.backends :as backends]
            [buddy.auth.middleware :refer [wrap-authentication]]
            [buddy.auth :refer [authenticated? throw-unauthorized]]))

(def secret "86bae26023208e57a5880d5ad644143c567fc57baaf5a942")

(def backend (backends/jws {:secret secret}))

(defn login [email]
  (let [claims {:email email
                :exp (time/plus (time/now) (time/seconds 1060))}]
    (jwt/sign claims secret)))

(defmethod  ig/init-key ::authentication [_ options]
  (fn [handler]
    (wrap-authentication handler backend)))

(defmethod ig/init-key ::authorization [_ options]
  (fn [handler]
    (fn [request]
      (if (not (authenticated? request))
        (-> (response "Unauthorized request")
            (assoc :status 401))
        (handler request)))))
