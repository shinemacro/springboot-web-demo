# java-openjdk-8
FROM java:openjdk-8
MAINTAINER zhaoyaohong "zhaoyaohong@aliyun.com"
ADD /usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar /usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java" ,"-jar","/usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar"]