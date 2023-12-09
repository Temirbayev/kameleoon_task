FROM openjdk:17
ADD /target/kameleoon-0.0.1-SNAPSHOT.jar kameleoon.jar
ENTRYPOINT ["java", "-jar", "kameleoon.jar"]