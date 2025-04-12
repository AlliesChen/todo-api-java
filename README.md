# Todo API in Java

## Project Overview

This project is a minimal, Spring Framework-based RESTful API for managing a todo list. It uses:

- Java 8+
- Spring Framework 5 (no Spring Boot)
- MyBatis (Java annotation mappers)
- Apache DBCP2 for connection pooling
- PostgreSQL as the database

## Configuration Summary

### applicationContext.xml

Declares Spring beans using XML-based config.

- dataSource: uses Apache DBCP2 for PostgreSQL connection pooling.
- sqlSessionFactory: sets up MyBatis with Java-based mappers.
- transactionManager: integrates Spring-managed transactions via @Transactional.
- mapperScannerConfigurer: automatically scans interfaces in com.github.allieschen.todo_api_java.mapper.