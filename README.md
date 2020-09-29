# bmdb-application-boot
###### Description 
A web application that allows a user to review Movies and Series. 
The app was created as a Maven multi module project. 
The application was created using the Spring Framework, Spring Boot. 
The Data of the application is stored in a MySql Database.
ORM is hanled by Spring Data.
The front end was created via bootstrap and thymeleaf template engine.
  
###### Structure
The application has 4 Modules:
**Domain module:** 
      - This contains the domain models
**Service module:**
      - This module includes the business logic
**Web module:** 
      - WEB controllers are implemeted in this module
**App module:** 
      - A Small Console application that uses the domain and the service module.
      
###### Testing the application

MySQL db name: bmd_fodor_norbert
MySQL service has to run in order to be able to test it
Build the project with Maven
In order to initialize the database with data the following url have to be called: 
http://localhost:8080/start

###### Test Users
**username:** pauly@gmail.com
**password:** admin

**username:** gjacob@gmail.com
**password:** admin
