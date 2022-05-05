FROM gradle:jdk17-alpine as build
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:17-jdk-slim as runtime
WORKDIR /app
COPY --from=build /app/build/libs/adilsdeals-0.0.1-SNAPSHOT.jar .
EXPOSE 8031
CMD ["java", "-jar", "adilsdeals-0.0.1-SNAPSHOT.jar"]
