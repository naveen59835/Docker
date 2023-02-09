FROM openjdk
WORKDIR usr/lib
ADD ./target/BEJ_C3_S1_Springboot_JWT_PC_1.-0.0.1-SNAPSHOT.jar /usr/lib/BEJ_C3_S1_Springboot_JWT_PC_1.-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BEJ_C3_S1_Springboot_JWT_PC_1.-0.0.1-SNAPSHOT.jar"]