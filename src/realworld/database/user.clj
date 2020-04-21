(ns realworld.database.user
  (:require [duct.database.mongodb.monger]
            [monger.collection :as mc]))

(defprotocol UserDatabase
  (create [db user])
  (find-one [db email]))

(extend-protocol UserDatabase
  duct.database.mongodb.monger.Boundary
  (create [{:keys [db]} user]
    (mc/insert-and-return db "users" user))

  (find-one [{:keys [db]} email]
    (mc/find-one-as-map db "users" {:email email})))
