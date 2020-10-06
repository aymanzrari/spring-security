
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE !>
<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>

<body>
	<h2>Luv2code Company Home Page - Yoohoo !! Silly Goose</h2>
	<hr>
	<p>Welcome to the luv2code company Home page !!</p>
	<hr>
	<p>
		Username :
		<security:authentication property="principal.username" />
		<br>
		<br> Role(s) :
		<security:authentication property="principal.authorities" />
	</p>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only For Manager Peps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems
			Meeting</a> (Only For Admin Peps)
	</p>
	</security:authorize>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>
