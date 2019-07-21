# Summary Service (Stress Tester)

Simple stress testing for the [Summary Service](https://github.com/milosjajac/summary-service) project.

## Run locally

Maven (or mvnw) and JRE 8 are required. Then, inside the project's directory, run:

```
mvn clean install
java -jar target/summary-service-stress-tester.jar
```

Request number and frequency can be changed in the `application.properties` resource file.