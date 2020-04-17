(ns realworld.auth
  (:require [integrant.core :as ig]
            [ring.util.response :refer [response]]
            [buddy.sign.jwt :as jwt]
            [buddy.auth :refer [authenticated? throw-unauthorized]]))

(def secret "86bae26023208e57a5880d5ad644143c567fc57baaf5a942")

#_(defmethod ig/init-key ::auth-fn [_ options]
  (fn [request token]
    (println token)
    (let [token (keyword token)]
      (get tokens token nil))))

#_(defmethod ig/init-key ::authorization [_ options]
  (fn [handler]
    (fn [request]

      (if (not (authenticated? request))
        (-> (response "Unauthorized request")
            (assoc :status 401))
        (handler request)))))

#_(jwt/sign {:user "test@daum.net"} "86bae26023208e57a5880d5ad644143c567fc57baaf5a942")
