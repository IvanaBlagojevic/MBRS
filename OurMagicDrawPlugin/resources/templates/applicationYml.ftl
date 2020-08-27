spring:
  application:
    name: ${artifactId}
  datasource:
    url: ${databaseUrl}
    username: ${databasePassword}
    password: ${databaseUsername}
    driverClassName : com.mysql.jdbc.Driver
    initialization-mode: always
  jpa:
    hibernate:
        ddl-auto: create-drop
    database-platform : org.hibernate.dialect.MySQL5Dialect

server:
  port: ${port}