# PassengerService 
Tools and Technologies Used:
-Spring Framework, -Spring Boot, JDK, JPA, Maven, Hibernate, JDBC, MySql(MySQL Workbench), IDE(IntelliJ IDEA), Postman(for handling requests and responses).

How to start a project:
-First download zip file, extract it and then import the project into your IDE.
-Also download sql file which you will also import into the MySql Workbench or wherever suits You.
-Go to resources and enter the username and password for MySQL. 
-Then start the project. 
-For handling API calls you can use Postman or similar software(for testing API).

JSON Format example:
{
    "firstName":"FirstName",
    "lastName":"LastName",
    "passportId":123456,
    "email":"email"
}


API Calls:
1.API Name     2.Http method     3.Path(http://localhost:8080)    4.Status code     5.Description
______________________________________________________________________________________________________________
1.GET Passengers    2.GET      3./api/v1/passengers             4.200(OK)          5.Get all passengers from database

2.POST Passenger    2.POST     3./api/v1/passengers             4.201(created)     5.A new passenger is created

3.GET Passenger	    2.GET      3./api/v1/passengers/{id}	4.200(OK)	   5.Get passenger by id

4.PUT Passenger     2.PUT      3./api/v1/passengers/{id}	4.200(OK)	   5.Update passenger

5.DELETE Passenger  2.DELETE   3./api/v1/passengers/{id}	4.204(No content)  5.Delete passenger by id



If You want to create database, here it is:
CREATE TABLE `passengersdb`.`info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `passport_id` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `passport_id_UNIQUE` (`passport_id` ASC) VISIBLE);
