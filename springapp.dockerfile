FROM openjdk:8

LABEL maintainer="Ali Kemal Tasci <ali_kemal_tasci@yahoo.com>"

RUN apt-get update && apt-get -y upgrade && apt-get install -y maven

WORKDIR /vol/app/

CMD ["mvn", "clean", "install", "spring-boot:run"]