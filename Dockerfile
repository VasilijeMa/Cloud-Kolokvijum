FROM openjdk:11
WORKDIR /app
COPY target/FilmApp-0.0.1-SNAPSHOT.jar /app/FilmApp-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD ["java", "-jar", "FilmApp-0.0.1-SNAPSHOT.jar"]