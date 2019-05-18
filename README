# Spring Boot + Webflux + JPA 공부

## Local 테스트

### 초기 세팅
```sh
# Run MySQL DB (처음)
$ docker run -d -p 13306:3306 -e MYSQL_ROOT_PASSWORD=test --name mysql_test mysql

# 만약 다시 돌리는 상황이라면
$ docker start mysql_test

# 처음일 경우 DB 초기화
$ mvn -Dflyway.configFiles=src/main/resources/db/migration/flyway.conf flyway:migrate
```

### RUN
```sh
$ mvn spring-boot:run -Dspring.profiles.active=local
```

