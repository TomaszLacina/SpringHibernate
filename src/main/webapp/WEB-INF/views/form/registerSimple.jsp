<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Super formularz</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>


	<form:form method="post" modelAttribute="person">
		<form:input path="login" />
		<form:password path="password" />
		<form:input path="email" />
		<form:checkbox path="cool"/>
		<input type="submit" value="Save">
	</form:form>
</body>
</html>