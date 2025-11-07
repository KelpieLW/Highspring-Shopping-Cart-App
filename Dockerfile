FROM gradle:8.4-jdk21 AS build
WORKDIR /app

COPY . .

RUN gradle clean build -x test

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
