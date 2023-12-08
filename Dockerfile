FROM amazoncorretto:17-alpine3.16-full as builder

WORKDIR /app

COPY . .

RUN ./gradlew clean bootJar

FROM amazoncorretto:17-alpine3.16-full

COPY --from=builder /app/build/libs/logConsumer-0.0.1.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]