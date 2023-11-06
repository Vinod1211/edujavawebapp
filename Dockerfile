FROM tomcat:8.5.91-jre8
COPY target/javawebapp*.war /usr/local/tomcat/webapps/javawebapp.war
