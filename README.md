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