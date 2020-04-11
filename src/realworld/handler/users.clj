(ns realworld.handler.users
  (:require [integrant.core :as ig]
            reitit.coercion.spec
            [realworld.dto.user :as user]
            [reitit.ring :refer [ring-handler router]]
            [realworld.util :refer [router-option]]))

(defmethod ig/init-key :realworld.handler.users/login [_ options]
  (ring-handler
   (router
    ["/api/users/login" {:name ::login
                         :post {:coercion reitit.coercion.spec/coercion
                                :parameters {:body ::user/user-input}
                                :handler (fn [{login-input :body-params}]
                                           {:status 200
                                            :body {:user
                                                   {:email "jake@jake.jake"
                                                    :token "jwt.token.here"
                                                    :username "jake"
                                                    :bio "I work at statefarm"
                                                    :image nil}}})}}]
    router-option)))
