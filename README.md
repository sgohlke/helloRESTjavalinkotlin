# helloRESTjavlinkotlin
Hello World REST example using Kotlin with Javlin

## How to run
Hello Rest will run on port 7000. You can run it either in IntelliJ Idea by running the HelloWorld.kt class or using the docker file.

Use Dockerfile(example):
- Run maven package in project
- Execute **docker build -t hw .** in project root folder
- Run **docker run --name hw -d -p 7000:7000 hw**