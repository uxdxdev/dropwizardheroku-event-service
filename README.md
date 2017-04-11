# Dropwizard Heroku Microservice

[![Build Status](https://travis-ci.org/damorton/dropwizard-heroku.svg?branch=master)](https://travis-ci.org/damorton/dropwizard-heroku)

https://protected-garden-89563.herokuapp.com/

A Dropwizard Microservice deployed to Heroku with a PostgreSQL database.

## API Endpoint test

```
curl https://protected-garden-89563.herokuapp.com/api/events
curl https://protected-garden-89563.herokuapp.com/api/query?message=hello
curl https://protected-garden-89563.herokuapp.com/api/hello
curl -X POST -d 'message=hello' https://protected-garden-89563.herokuapp.com/api/postparam
curl -X POST -d 'hello' https://protected-garden-89563.herokuapp.com/api/postbody
```

## Project Structure

### Example package names:

```
com.bitbosh.DropwizardHeroku.resources (API, communicates will all parts of the Microservice and contains Domain objects)
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
    │   │           ├── resources
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

# References

https://www.sitepoint.com/tutorial-getting-started-dropwizard/
