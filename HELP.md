# Read Me First
The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Spring Boot DevTools, Rest Repositories'. As a result, your application may not work as expected.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#using-boot-devtools)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.10.0-SNAPSHOT/reference/htmlsingle/#spring-aot-maven)

## Spring Native

This project has been configured to let you generate a lightweight container running a native executable.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.10.0-SNAPSHOT/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 magneto:0.0.1-SNAPSHOT
```
