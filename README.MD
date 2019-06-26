##conversations

CREATE NATIVE IMAGE 
./mvnw package -Pnative

RUN NATIVE IMAGE:
./target/search-obj-1.0-SNAPSHOT-runner


CREATE NATIVE IMAGE USING DOCKER
./mvnw package -Pnative -Dnative-image.docker-build=true



docker build -f src/main/docker/Dockerfile.native -t coopservice/search-obj .



docker run -i --rm -p 8080:8080 coopservice/search-obj
