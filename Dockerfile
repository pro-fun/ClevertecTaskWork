FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./domain/build/libs/domain-1.0-SNAPSHOT.jar .
CMD ["java","-jar","domain-1.0-SNAPSHOT.jar"]