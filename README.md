# Employee API Automation Framework

This project is a Rest-Assured + TestNG based automated API test suite for testing CRUD operations on Employee data using https://crudcrud.com/

## Requirement:
- Java 11 and above

## Tech Stack

- Java
- Maven
- Rest-Assured
- TestNG
- JSON Schema Validator

## Setup

* Clone this project
* Open using Intellij IDE
* Maven will install the dependencies automatically

### To Run the test in Terminal:

`mvn test -Dtoken={uniqueToken}`

**Note:**

* Get the unique token which expires every 24 hours from https://crudcrud.com/
* eg) `mvn test -Dtoken=ac36aaebcbd74d539f8f74111baf38ab `
