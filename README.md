# url-shortener

URL SHORTENER

The source repository for URL Shortener project.

It provides APIs for converting length URls into shorter URIs. For example:

Input URI: "https://www.google.com/"

Output URI: "vat.sl/1"


It also provides mechanism to fetch the original link from the short link.


The application has centralized exception handling using @ControllerAdvice.

The application uses SLF4J and logback for logging.

The application uses H2 db (in-memory DB).

The application is configured with graceful shutdown.

The application performs input validations.


# Prerequisites to run the application:
Java 11

Gradle


#Command to build application:
**./gradlew build**


#Command to run application:
**./gradlew bootRun**


#Command to run automated unit tests:
**./gradlew test**


# After test execution, code coverage report can be found at:
build/reports/jacoco/test/html/index.html


# To test APIs manually import the Postman collection located at:
src/main/resources/URL Shortener.postman_collection.json


# Logging levels:
Change the desired levels in logback.xml and application.properties.


# Graceful shutdown:
Server is configured with graceful shutdown period of 1 minute. To change, modify "spring.lifecycle.timeout-per-shutdown-phase=1m" property in applications.properties.


# OpenAPI Documentation for REST APIs:
While application is running, open below links in the browser:


http://localhost:8080/projects/shortener/swagger-ui/index.html

http://localhost:8080/projects/shortener/v3/api-docs/

