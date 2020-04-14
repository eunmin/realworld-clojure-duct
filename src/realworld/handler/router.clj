(ns realworld.handler.router
  (:require [integrant.core :as ig]
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]
            [reitit.coercion.spec]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as coercion]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [reitit.ring.middleware.parameters :as parameters]
            [reitit.ring.middleware.exception :as exception]
            [muuntaja.core :as m]
            [expound.alpha :as expound]))

(defn coercion-error-handler [status]
  (let [printer (expound/custom-printer {:theme :figwheel-theme, :print-specs? false})
        handler (exception/create-coercion-handler status)]
    (fn [exception request]
      (printer (-> exception ex-data :problems))
      (handler exception request))))

(defmethod ig/init-key :realworld.handler/router [_ options]
  (ring/ring-handler
   (ring/router [options
            ["" {:no-doc true}
             ["/swagger.json" {:get (swagger/create-swagger-handler)}]
             ["/api-docs/*" {:get (swagger-ui/create-swagger-ui-handler)}]]]
           {:data
            {:coercion reitit.coercion.spec/coercion
             :muuntaja m/instance
             :middleware [parameters/parameters-middleware
                          muuntaja/format-negotiate-middleware
                          muuntaja/format-response-middleware
                          exception/exception-middleware
                          muuntaja/format-request-middleware
                          coercion/coerce-response-middleware
                          coercion/coerce-request-middleware]}})))

#_[(exception/create-exception-middleware
  (merge
   exception/default-handlers
   {:reitit.coercion/request-coercion (coercion-error-handler 400)
    :reitit.coercion/response-coercion (coercion-error-handler 500)}))
 rrc/coerce-request-middleware
 rrc/coerce-response-middleware]
