<html>
<head><%@ include file="header.jsp"%></head>
<body>
	<form action="<%=JWAView.UploadImageViewCTL%>" method="post"
		enctype="multipart/form-data">
		Select Image to Upload:<input type="file" name="photo"> <br>
		<input type="submit" value="Upload">
	</form>
</body>
<%@ include file="footer.jsp"%>
</html>