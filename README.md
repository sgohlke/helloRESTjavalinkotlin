# helloRESTjavalinkotlin
Hello World REST example using Kotlin with Javalin

## How to run
Hello Rest will run on port 7000. You can run it either in IntelliJ Idea by running the HelloWorld.kt class or using the docker file.

Use Dockerfile(example):
- Run maven package in project
- Execute **docker build -t hw .** in project root folder
- Run **docker run --name hw -d -p 7000:7000 hw**

## Endpoints
- / : root endpoint, returns "Hello REST" and a current Datetime
- /person : Returns all Persons available
- /person/0 : From 0 to 2, returns specific Person with given index 
- /graphql : GraphQL post endpoint

### GraphQL endpoint

Send following body in post request to receive an answer from the GraphQL endpoint.

Get all persons:
`{
   persons() {
       lastName
       firstName
       age
     }
   }`
   
Get all persons with age 40:
`{
   persons(age:40) {
       lastName
       firstName
       age
     }
   }`
   
Get the firstName of all persons with age 40 and lastName Meier:
   `{
      persons(age:40, lastName:"Meier") {
          lastName
          firstName
          age
        }
      }`