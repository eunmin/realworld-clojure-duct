(ns realworld.handler.users
  (:require [buddy.sign.jwt :as jwt]
            [clj-time.core :as time]
            [integrant.core :as ig]))

(defmethod ig/init-key :realworld.handler.users/login [_ options]
  (fn [{login-input :body-params}]
    (let [claims {:email (:email login-input)
                  :exp (time/plus (time/now) (time/seconds 60))}
          token (jwt/sign claims "aaaa")]
      {:status 200
       :body {:user
              {:email "jake@jake.jake"
               :token token
               :username "jake"
               :bio "I work at statefarm"
               :image nil}}})))


(defmethod ig/init-key :realworld.handler.users/registration [_ options]
  (fn [{registration-input :body-params}]
    {:status 200
     :body {:user
            {:email "jake@jake.jake"
             :token "jwt.token.here"
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))
