(ns realworld.handler.users
  (:require [clojure.spec.alpha :as s]
            [integrant.core :as ig]
            [realworld.database.user :as user]
            [realworld.auth :refer [login]]))

(defmethod ig/init-key :realworld.handler.users/login [_ options]
  (fn [{login-input :body-params :as req}]
    {:status 200
     :body {:user
            {:email "test@test.com"
             :token (login "jake@jake.jake")
             :username "jake"
             :bio "I work at statefarm"
             :image nil}}}))

(defmethod ig/init-key :realworld.handler.users/registration [_ {:keys [db]}]
  (fn [{registration-input :body-params}]
    (let [email (:email registration-input)
          user (user/find-one db email)]
      (if (nil? user)
        {:status 200 :body {:user
                            (merge {:bio nil
                                    :token (login email)
                                    :image nil}
                                   (user/create db (:user registration-input)))}}
        {:status 409 :body {:errors {:body ["Conflict"]}}}))))


