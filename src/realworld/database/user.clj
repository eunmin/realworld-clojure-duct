(ns realworld.database.user)

(defprotocol UserDatabase
  (find-one [this email])
  (save [this user]))
