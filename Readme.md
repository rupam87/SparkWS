Readme
=======
This project aims at creating a sample Web Application using Spark (Jetty server in the background)
to host the service.
The Controller code has routing logic embedded which in turn uses a public webservice (Go Rest API) to mimic 
the middleware and backend logic.

Typically one would like to write their own implementation logic here by processing the request details and 
interacting with backend DB, and framing the response objcet (XML / JSON).

The purpose of this project is to merely establish how easy and fast it is to write a web service using Spark.