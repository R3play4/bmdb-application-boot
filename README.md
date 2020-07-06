# bmdb-application-boot
Description: 
  A web application that allows a user to review Movies and Series. 
  The app was created as a Maven multi module project. 
  The application was created using the Spring Framework. 
  The Data of the application is stored in a MySql Database.
  ORM is hanled by Spring Data.
  The front end was created via bootstrap.
  
Structure:
  The application has 4 Maven Modules: 
    Domain module: 
      - This contains the domain models
    Service module: 
      - This module includes the business logic
    Web module: 
      - WEB controllers are implemeted in this module
    App module: 
      - A Small Console application that uses the domain and the service module.
      
Testing the application: 

MySQL db name: bmd_fodor_norbert

Testing via CMD: 
Console App
java -jar <your path>.jar-with-dependencies

Web App
java -jar <your path>.war

In order to initialize the database with data the following url have to be called: 
http://localhost:8080/start

Users: 
username: pauly@gmail.com
password: admin

username: gjacob@gmail.com
password: admin
