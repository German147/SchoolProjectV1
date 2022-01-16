
# School App project for Study Security
###### Desktop application created with SpringBoot, and Postgresql relational database.
<br/>

### Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This is a new version implementing and learning JWT with refresh tokens. It has no UI yet. But you can perform the queries from POSTMAN. 


### Technologies and dependencies


````
* Java 1.8
* Spring Boot version: 2.1.9
* Spring Web
* Spring Security
* Devtools
* Validation
* Guava version 28.1-jre
* Jpa
* PostgreSQL
* Lombok
````

## Setup
To run this project, install it locally, open it into your IDE, go to the application.properties file and then 
change the database configuration like driver, Url, db name, user and password. Finally, run it as any other java 
application. 

```
   dataSourceBuilder.driverClassName("org.postgresql.Driver");
   dataSourceBuilder.url("jdbc:postgresql://localhost:5432/dbName");
   dataSourceBuilder.username("username");
   dataSourceBuilder.password("password");
```

### Author
This repository was built using documentation on the internet.

* **Barrera Luis German**  - *Java Developoer*




 
 


