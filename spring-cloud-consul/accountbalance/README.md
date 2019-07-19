### Account Balance Service Application

This repository contains accounts application written using Spring Boot, Spring cloud, Spring data and other frameworks.

http://localhost:8080/swagger-ui.html

#### Program Arguments
Following program arguments need to be passed.

##### Mandatory:
--HOST=localhost --PORT=8080


##### when Consul to be enabled:
--consul.agent.host=localhost --consul.agent.port=8500


#### Enable/disable Consul
To enable or disable consul change following in application.yaml.

    bus:
      enabled: false
    consul:
      enabled: false