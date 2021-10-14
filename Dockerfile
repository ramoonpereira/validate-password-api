#
# Build
#
FROM maven:3.8.3-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package
#
FROM maven:3.8.3-openjdk-17-slim
COPY --from=build /home/app/target/password.validate-0.0.1-SNAPSHOT.jar /usr/local/lib/password.validate-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/password.validate-0.0.1-SNAPSHOT"]