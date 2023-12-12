#stage 1
#Start with a base image containing Java runtime
FROM openjdk:17-slim as build

# Add Maintainer Info
LABEL maintainer="Htun Khaing Lynn <htunkhainglynn13@gmail.com>"

# Add the application's jar to the container
COPY target/book-microservice-0.0.1-SNAPSHOT.jar app.jar

#unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

#stage 2
#Same Java runtime
FROM openjdk:17-slim

#Add volume pointing to /tmp
VOLUME /tmp

#Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#execute the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.project.bookstore.BookMicroserviceApplication"]