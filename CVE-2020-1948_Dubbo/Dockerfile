FROM maven:3.5-jdk-8 AS pre_jar

COPY src/ /src/

WORKDIR /src/

RUN mvn package -DskipTests=true

FROM szgx/java:8u111_debian

LABEL maintainer="mO0n@guanxin" version="1.0"

COPY --from=pre_jar --chown=0:0 /src/target/dubbo.jar /dubbo.jar

WORKDIR /

ENTRYPOINT ["bash", "-c", "java -jar /dubbo.jar"]

EXPOSE 12345