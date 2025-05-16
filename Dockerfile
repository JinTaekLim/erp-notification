FROM openjdk:21-jdk-slim
COPY . .
RUN ./gradlew clean build
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "build/libs/notification-0.0.1-SNAPSHOT.jar"]
