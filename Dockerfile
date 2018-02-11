FROM openjdk:8
ADD build/libs/CruiseExcursionBookingSystem.jar CruiseExcursionBookingSystem.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","CruiseExcursionBookingSystem.jar"]