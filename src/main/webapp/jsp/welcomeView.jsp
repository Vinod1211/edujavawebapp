<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Madhuri Education</title>
</head>
<%@ include file="header.jsp"%>
<body>
<%="Welcome: "+session.getAttribute("user")%>
	<h1>Welcome to Madhuri Education......</h1>

</body>

<%@ include file="footer.jsp"%>
</html>