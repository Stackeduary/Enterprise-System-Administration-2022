FROM gradle:jdk11-alpine as build
WORKDIR /app
COPY . .
RUN gradle build -x test

FROM openjdk:11-jdk-slim as runtime
WORKDIR /app
COPY --from=build /app/build/libs/adilsdeals-0.0.1-SNAPSHOT.jar .
EXPOSE 8031
CMD ["java", "-jar", "adilsdeals-0.0.1-SNAPSHOT.jar"]
