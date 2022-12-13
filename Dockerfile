FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /var/jenkins_home/api
COPY .mvn/ .mvn
COPY pom.xml ./
RUN mvn clean install -DskipTests
COPY src ./src
CMD ["mvn", "spring-boot:run"]


