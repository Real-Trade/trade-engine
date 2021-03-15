FROM openjdk:11
COPY build/libs/*.jar tradeengine.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","tradeengine.jar"]