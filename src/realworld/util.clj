(ns realworld.util
  (:require 
            [reitit.ring.coercion :as rrc]
            [reitit.ring.middleware.exception :as exception]
            [expound.alpha :as expound]))

(defn coercion-error-handler [status]
  (let [printer (expound/custom-printer {:theme :figwheel-theme, :print-specs? false})
        handler (exception/create-coercion-handler status)]
    (fn [exception request]
      (printer (-> exception ex-data :problems))
      (handler exception request))))

(def router-option {:data
                    {:middleware [(exception/create-exception-middleware
                                   (merge
                                    exception/default-handlers
                                    {:reitit.coercion/request-coercion (coercion-error-handler 400)
                                     :reitit.coercion/response-coercion (coercion-error-handler 500)}))
                                  rrc/coerce-request-middleware
                                  rrc/coerce-response-middleware]}})
