FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/demo-0.0.1-SNAPSHOT.jar /opt/app/redis-cluster-spring.jar
CMD ["java","-jar", "/opt/app/redis-cluster-spring.jar"]
