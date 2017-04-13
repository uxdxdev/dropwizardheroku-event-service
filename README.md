# Dropwizard Heroku (Event) Microservice

[![Build Status](https://travis-ci.org/damorton/dropwizard-heroku.svg?branch=master)](https://travis-ci.org/damorton/dropwizard-heroku) [![Coverage Status](https://coveralls.io/repos/github/damorton/dropwizard-heroku/badge.svg?branch=master)](https://coveralls.io/github/damorton/dropwizard-heroku?branch=master)

https://protected-garden-89563.herokuapp.com/

A Dropwizard (Event) Microservice deployed to Heroku with a PostgreSQL database.

## API Endpoints for ExampleResource

```
curl https://protected-garden-89563.herokuapp.com/api/example/query?message=hello
curl https://protected-garden-89563.herokuapp.com/api/example/hello
curl -X POST -d 'message=hello' https://protected-garden-89563.herokuapp.com/api/example/postparam
curl -X POST -d 'hello' https://protected-garden-89563.herokuapp.com/api/example/postbody
```

## API Endpoints for EventResource

```
curl https://protected-garden-89563.herokuapp.com/api/event/{name}
curl -H "Content-Type: application/json" -X POST -d '{"name":"Sesh","description":"Drinkys","location":"Toms","date":"2017-04-11"}' https://protected-garden-89563.herokuapp.com/api/event
```

## Project Structure

### Example package names:

```
com.bitbosh.DropwizardHeroku.api (Resources & Representations. Communicates will all parts of the Microservice and contains Domain objects)
com.bitbosh.DropwizardHeroku.service (Coordination across multiple Domain modules, multiple business transactions)
com.bitbosh.DropwizardHeroku.domain (Domain Modules/Classes, this Microservices business logic)
com.bitbosh.DropwizardHeroku.repositories (Dao, handles multiple Domain entities and has access to persistent storage)
com.bitbosh.DropwizardHeroku.gateways (Encapsulates message passing and error handling with other Microservices)
com.bitbosh.DropwizardHeroku.client (HTTP Client to communicate with other Microservices)
...
```

### Structure

```
.
├── config.yml
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── DropwizardHeroku    
    │   │           ├── api
    │   │           ├── service
    │   │           ├── domain
    │   │           ├── repositories
    │   │           ├── gateways
    │   │           ├── client
    │   │           ├── DropwizardHerokuApplication.java
    │   │           ├── DropwizardHerokuConfiguration.java
    │   │           ├── ...
    │   └── resources
    │       ├── assets
    │       └── banner.txt
    └── test
        ├── java
        │   └── com
        │       └── DropwizardHeroku
        │           ├── api
        │           ├── service
        │           ├── domain
        │           ├── repositories
        │           ├── gateways
        │           ├── client
        │           ├── ...
        └── resources
            └── fixtures
```

# Tutorial

http://www.bitbosh.com/2017/04/microservices-with-dropwizard-on-heroku.html
