The CQRS 

Microservices allow loose coupling amongst each service application, which promotes independence and increases scalability. Specfically, microservices can be run in multiple instances to match the demand from the client-user. Moreover, this project utilizes Eureka Service Discovery to register the running instances of the Products, Users, and Orders microservices. Furthermore, a Configuration Server helps establish a centralized location to configure/update changes to running instances of mulitple microservices. As a result, different services can be maintained and highly scaled.

A general microservice archetiture is structured as "Microservice A" sends a request to "Microservice B", then "Microservice B" responds back. However, several problems can occur in scenarios where "Microservice A" needs to send requests to several other microservices pertaining to different types of requests.
THe CQRS 
detect if a microservice is 
