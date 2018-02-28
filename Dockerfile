FROM ubuntu-jdk8
MAINTAINER zhaoyaohong "zhaoyaohong@aliyun.com"
ADD /usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar /usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar
EXPOSE 39001
ENTRYPOINT ["java" ,"-jar","/usr/project/springboot-web-demo-0.0.1-SNAPSHOT.jar"]