FROM maven:3.9-amazoncorretto-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine
VOLUME /tmp
COPY --from=build /app/target/*.jar booking_service.jar
ENTRYPOINT [ "java", "-jar", "/booking_service.jar" ]
