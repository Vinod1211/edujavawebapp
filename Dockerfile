FROM tomcat:8.5.91-jre8
ENV dbDriver=com.mysql.jdbc.Driver dbConnectionUrl=jdbc:mysql://mysql_db:3306/eduwebappdb dbUserName=root dbPassword=root
COPY target/javawebapp*.war /usr/local/tomcat/webapps/javawebapp.war
