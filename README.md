# Todo API in Java

## Project Overview

This project is a minimal, Spring Framework-based RESTful API for managing a todo list. It uses:

- Java (JDK 11)
- Spring Framework 5
- MyBatis (Java annotation mappers)
- Apache Tomcat (for deployment)
- Apache DBCP2 for connection pooling
- PostgreSQL as the database
- Maven (for build/lifecycle management)

## Deployment

- Maven `packaging` set to `war` to allow deployment to Tomcat.
- Tomcat 9
- IntelliJ CE with Smart Tomcat plugin

After the service started, you can test with:

```shell
curl http://localhost:8080/todo-api-java/ping
curl http://localhost:8080/todo-api-java/1
curl -H Content-Type: application/json http://localhost:8080/todo-api-java/create -d '{"title":"test"}'
```

## Configuration Summary

Java-based configuration for Spring MVC setup.

- `DispatcherServlet` set up via `WebAppInitializer` (no `web.xml`)

### AppConfig

- `@Configuration`
- `@ComponentScan` reads folders that should be added to the context.
- `@EnableMVc` enabled Spring's annotation-based MVC support.
- DataSource
- SqlSessionFactory
- MapperScan
- TransactionManager

### Support for Java 8+ `LocalDateTime`

- jackson-datatype-jsr310: is required for `LocalDateTime` serialization.
- JavaTimeModule: is registered manually because we're not using Spring Boot.
- ISO-8601 formatting via `@JsonFormat`

### applicationContext.xml (doesn't work)

Declares Spring beans using XML-based config.

- dataSource: uses Apache DBCP2 for PostgreSQL connection pooling.
- sqlSessionFactory: sets up MyBatis with Java-based mappers.
- transactionManager: integrates Spring-managed transactions via @Transactional.
- mapperScannerConfigurer: automatically scans interfaces in com.github.allieschen.todo_api_java.mapper.

## Error Handling

- Implemented a global `@ControllerAdvice` handler.
- Exceptions return JSON-formatted error response with correct HTTP status codes.
