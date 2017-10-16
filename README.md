# MongoDB REST service implemented using Spring Boot

This example project shows the use-case of a simple Spring Boot web service REST application with MongoDB backend.

The web service exposes two endpoints:
* ```/addMovie``` with POST request parameters: movieName, movieDescription and year
	this endpoint adds a new movie to the database based on the parameter values specified by the user
* ```/movieSearch``` with POST request parameters: movieName and year
	searches for a movie either by the specified movie name, the specified year or both the year AND the movie inclusive
	
In the background, the endpoints use embedded MongoDB to store the data. All of the data is stored through a CRUD repository (a feature of Spring) which allows specification of custom queries using keywords predefined in Spring Data (more information can be found [here]( https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/repository-query-keywords.html)) after which Spring creates the specific queries in the background (in this case specificly for MongoDB).

The easiest way to run the service is by using the packaged jar file and invoking
java -jar mongodb-springboot-restservice-0.0.1.jar
this will run a new Spring Boot application which uses an embedded Tomcat server to execute the service and expose the endpoints to port 8080 on the localhost address (127.0.0.1).

The way to invoke the endpoints would be to use curl for UNIX systems and a browser extension for Windows such as [Advanced REST client for Google Chrome](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo)
Here are a couple of examples using curl:

ADDITION OF NEW MOVIES
```
curl -d 'movieName=Batman Begins&movieDescription=Sample description&year=2005' -H "Accept: application/json" -X POST http://localhost:8080/addMovie
curl -d 'movieName=The Big Short&movieDescription=Economic crysis&year=2015' -H "Accept: application/json" -X POST http://localhost:8080/addMovie
```

MOVIE SEARCH
```
curl -d 'year=2011' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
curl -d 'movieName=the game' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
curl -d 'movieName=Batman' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
curl -d 'movieName=game&year=1997' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
curl -d 'movieName=the&year=2004' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
curl -d 'year=2015' -H "Accept: application/json" -X POST http://localhost:8080/movieSearch
```

The database is prefilled with some movie data initially (the prefilled data can be seen in the @PostConstruct method in the RestServiceApplication class - the main config class for Spring Boot in this case).
The web service can be extended if needed with a web interface using a templating engine such as thymeleaf + a javascript frontend framwork such as AngularJS or React.