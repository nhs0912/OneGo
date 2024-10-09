FROM amazoncorretto:17 AS builder
WORKDIR /app
COPY ./ ./
RUN ./gradlew clean build -x test

#APP
FROM amazoncorretto:17-alpine-jdk
COPY --from=builder /app/build/libs/*SNAPSHOT.jar onegoProject.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "onegoProject.jar"]
