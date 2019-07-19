# spring-cloud-consul
Demostration of Microservices architecture with Spring Boot/Cloud, Consul service discovery, also using Netflix Hystrix.

Two microservices both registered to Consul for service discovery / service mesh.
Account balance service calls offers to provide offers to caller via Consul.

* Account Balance Service - [accountbalance](https://github.com/manmohanp/microservices-demos/accountbalance)
* Offers Service - [offers](https://github.com/manmohanp/microservices-demos/offers)


### Starting Consul in dev (local)

$ consul agent -dev

Accessing consul UI - http://locahost:8500
