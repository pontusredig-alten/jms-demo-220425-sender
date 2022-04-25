FROM openjdk:17
COPY ./target/jms-demo-220425-0.0.1-SNAPSHOT.jar /usr/src/jms-220425/
WORKDIR /usr/src/jms-220425
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jms-demo-220425-0.0.1-SNAPSHOT.jar"]
