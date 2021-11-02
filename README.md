The CQRS (Command-Query Responsibility Segregation) pattern divides Commands (POST, PUT, DELETE, PATCH) and Queries (GET). This project is centered on this design pattern to structure this E-Commerce application. Therefore, this project uses an Event-Driven Archetitecture to separate out the products, users, and orders microservices. Moreover, this project is built using Java and the Spring Boot Framework to construct a robust backend system to scale and operate based on the amount of events created, as well as to monitor failing transactions and microservices.

![image](https://user-images.githubusercontent.com/84652073/138966250-4034339b-6a40-4464-bff3-6f83dd037b3c.png)

Microservices allow loose coupling amongst each service application, which promotes independence and increases scalability. Specfically, microservices can be run in multiple instances to match the demand from the client-user. Moreover, this project utilizes Eureka Service Discovery to register the running instances of the Products, Users, and Orders microservices. Furthermore, a Configuration Server helps establish a centralized location to configure/update changes to running instances of mulitple microservices. As a result, different services can be maintained and highly scaled.

A general microservice archetiture is structured as "Microservice A" sends a request to "Microservice B", then "Microservice B" responds back. However, several problems can occur in scenarios where "Microservice A" needs to send requests to several other microservices pertaining to different types of requests. The problem further escalates when we need to add/update/delete microservices. Therefore, we can mitigate problems from the general microservice archetiture by implementing a Event-Driven Archetiture. For example, using the Publisher and Subsriber framework, "Microservice A" (producer) can publish commands(Create, Update, Delete requests) and send them to a Message Broker (events), which will be sent to several corresponding microservices (consumers) similar to a subsription service. Through utilizing the Event-Driven Archetiture and a message broker, we can achieve asynchronous microservices to obtain requests and execute multiple responses at a time without having to wait for the current response to finish in order to move on to the next response.

![image](https://user-images.githubusercontent.com/84652073/138963047-af778ce5-c36d-4422-a74b-946f58721c76.png)

![image](https://user-images.githubusercontent.com/84652073/138961723-98051e87-d3ca-4990-bfe2-9e0b515ec106.png)

Contrary to Monolithic Archetiture, microservices can accomplish consistency by incorporating the SAGA Design Patterns. One SAGA Design Pattern is the Choreography-Based Saga ensures explicit "failed events" and can roll back several transactions from the chain of commands in the order that they occurred. For example, if one microservice mid-way down the transaction chain of commands fails to execute an event, then compensating transactions will occur at that last location and undo/cancel any preceding transactions that modified any states necessary to carry out that "failed event."

![image](https://user-images.githubusercontent.com/84652073/138966639-3d01923d-39fb-4ca0-9591-1547e5edc651.png)

In addition, this project integrates the Axon Framework to manage visually track each microservice. Based on how they interact and the amount of requests coming in, business decisions to scale up/down a specific microservice can become more convenient with the help of Axon dashboard. This project incorporates the Axon dashboard to monitor and test whether or not transactions were completely successful. For example, if a product request was successfully completed, then the Axon dashboard would have registered the transaction in its log. 

![axonserver](https://user-images.githubusercontent.com/84652073/138995353-bb92458e-9741-4569-8160-58d3301099e7.JPG)


![axondashboard](https://user-images.githubusercontent.com/84652073/138995327-fd535fcd-c0a9-49c3-86a8-982170f7cd80.JPG)

In terms of deployment, I employed AWS Elastic Beanstalk, as well as implemented AWS DynamoDB for the NoSQL databases for the Product, Payment, and Order Microservices. In regards to E-Commerce applications and Event-Driven archetictures, it is most suitable and flexible to utilize non-relational databases (AWS DynamoDB) because it allows more versatility to access certain collections of data by its "attributeName" and to input them into function calls for rendering communications between microservices.

![Screen Shot 2021-11-01 at 9 19 23 PM](https://user-images.githubusercontent.com/84652073/139786309-19aee9b1-6486-4520-9eef-d0e3dccb6268.png)


![Screen Shot 2021-11-01 at 7 27 54 PM](https://user-images.githubusercontent.com/84652073/139786354-463f9b4e-2880-4cd6-9f9e-6b3f87ed6f02.png)

<img width="1362" alt="Screen Shot 2021-11-01 at 7 28 07 PM" src="https://user-images.githubusercontent.com/84652073/139786365-5442d09d-860b-4e83-8aff-b4ee68341ed8.png">


![Screen Shot 2021-11-01 at 7 28 47 PM](https://user-images.githubusercontent.com/84652073/139786399-2573b773-7eb6-4d05-abe4-d6c6a2551649.png)



<img width="1777" alt="Screen Shot 2021-11-01 at 7 35 26 PM" src="https://user-images.githubusercontent.com/84652073/139786478-f87a03aa-9000-4549-889d-4c191cc72463.png">






