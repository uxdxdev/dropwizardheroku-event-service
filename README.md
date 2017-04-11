# Dropwizard Heroku Microservice

[![Build Status](https://travis-ci.org/damorton/dropwizard-heroku.svg?branch=master)](https://travis-ci.org/damorton/dropwizard-heroku)

https://protected-garden-89563.herokuapp.com/

A Dropwizard Microservice deployed to Heroku with a PostgreSQL database.

## API Endpoint test

```
curl https://protected-garden-89563.herokuapp.com/query?message=hello
curl https://protected-garden-89563.herokuapp.com/hello
curl -X POST -d 'message=hello' https://protected-garden-89563.herokuapp.com/postparam
curl -X POST -d 'hello' https://protected-garden-89563.herokuapp.com/postbody
```

## Project Structure

###E xample package names:

```
com.bitbosh.DropwizardHeroku.resources
com.bitbosh.DropwizardHeroku.service
com.bitbosh.DropwizardHeroku.domain
com.bitbosh.DropwizardHeroku.repositories
com.bitbosh.DropwizardHeroku.gateways
com.bitbosh.DropwizardHeroku.client
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
    │   │           ├── resources (API, communitcates will all parts of the Microservice)
    │   │           ├── service (Coordination across multiple Domain modules, multiple business transactions)
    │   │           ├── domain (Domain Modules/Classes, this Microservices business logic)
    │   │           ├── repositories (Dao, handles multiple Domain entities and has access to persistent storage)
    │   │           ├── gateways (Encapsulates message passing and error handling with other Microservices)
    │   │           ├── client (HTTP Client to communicate with other Microservices)
    │   │           ├── DropwizardApplication.java
    │   │           ├── DropwizardApplicationConfiguration.java
    │   │           ├── ...
    │   └── resources
    │       ├── assets
    │       └── banner.txt
    └── test
        ├── java
        │   └── com
        │       └── mydomain
        │           ├── resources
        │           ├── service
        │           ├── domain
        │           ├── repositories
        │           ├── gateways
        │           ├── client
        │           ├── ...
        └── resources
            └── fixtures
```
