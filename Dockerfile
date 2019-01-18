FROM openjdk:8
ADD target/OrderingMicroService.jar OrderingMicroService.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar", "OrderingMicroService.jar"]
