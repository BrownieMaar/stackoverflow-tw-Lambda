# Stackoverflow++
### A School project by the not-that-well-known _Lambda Males_.

### The Lambda Males
* Márton BARNA ([@BrownieMaar](https://github.com/BrownieMaar))
* Siyar FAROUQ ([@siyar25](https://github.com/siyar25))
* Dénes FÜLÖP ([@fulopdenes](https://github.com/fulopdenes))
* Zoltán MIHÁLYFI ([@miz092](https://github.com/miz092))

## About the Project

This was our last team project in [Codecool](https://codecool.com/)'s 10-month Full Stack developer course's OOP module. It was the first time we used Java with Spring Boot in a Full Stack application.

**This repository is only the backend of the project!** You can find the frontend repository [here](https://github.com/BrownieMaar/stackoverflow-frontend).

_This README is only about the backend part of the project. For the frontend documentation, refer to the frontend repository's README._

### Used Technologies

* Java 17
* Spring Boot
* PostgreSQL

## Getting Started

You'll need the Maven build tool and Java 17 to build the application. For the database a new PostgreSQL database will be needed called `stackoverflow`. Username and password for the database need to be passed to the application as _environment variables_. To initialize the database with placeholder data, run the `init.sql` file in the `resources` folder.

Now the application ca be started. Spring Boot will launch the server, and the endpoints will be live.
