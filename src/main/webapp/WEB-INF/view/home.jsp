<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE !>
<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>

<body>
	<h2>Luv2code Company Home Page - Yoohoo !! Silly Goose</h2>
	<hr>
	<p>Welcome to the luv2code company Home page !!</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>
