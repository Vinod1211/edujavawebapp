<%@ page import="javawebapp.controller.JWAView"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<%String userSession = (String)session.getAttribute("user");%>
	<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
		<a class="navbar-brand" href="<%=JWAView.APP_CONTEXT%>">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
		<%if(userSession==null) {%>
			
				<li class="nav-item active"><a class="nav-link"
					href="<%=JWAView.HomeCTL%>">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<%=JWAView.LoginCTL%>">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=JWAView.UserViewCTL%>">Registration</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">ContactUS</a>
				</li>
				<li class="nav-item"><a class="nav-link disabled" href="#">AboutUS</a>
				</li>
				<%} else {%>
				<li class="nav-item active"><a class="nav-link"
					href="<%=JWAView.HomeCTL%>">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">ContactUS</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">AboutUS</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<%=JWAView.UserListCTL%>">UserList</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<%=JWAView.UploadImageViewCTL%>">UploadImage</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href=<%=JWAView.LoginCTL+"?operation=logout"%>>Logout</a>
				</li>
			</ul>
			<%} %>
		</div>
	</nav>

</body>
</html>