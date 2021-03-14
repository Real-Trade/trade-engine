FROM openjdk:11
COPY build/libs/*.jar trade-engine.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","trade-engine.jar"]