### E-commerce Application
This the  SpringBoot web e-commerce application that integrates with a PostgreSQL database, Redis cache and uses Docker to run in a container. The application have a REST API that allows users to perform CRUD (create, read, update, delete) operations on a data model representing a simple e-commerce platform. The REST API is defined using OpenAPI.
 

#### Getting Started

* Download and extract the zip or clone from the repository.

Execute following command to start the application:

* Open the terminal and execute `docker build -t . ecomm_app`
* Execute `docker-compose up`
* Try to access the REST endpoints using swagger URL.
* Also find postman collection Ecommerce App.postman_collection.json to access the REST endpoints.

#### OpenAPI and Swagger URL
Once the application starts successfully, you can access following links:

* [Open API 3](http://localhost:8080/v3/api-docs)
* [Swagger UI](http://localhost:8080/swagger-ui/index.html)
