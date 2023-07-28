FROM tomcat:8.0.20-jre8
COPY target/JavaWebApp*.war /usr/local/tomcat/webapp/JavaWebApp.war
