<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Super formularz</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>
	
	<form:form method="post" modelAttribute="author">
		<form:input path="firstName"/>
	   	<form:input path="lastName"/>
		<form:input path="pesel"/>
	   	<form:input path="email"/>
		<form:input path="yearOfBirth"/>
		
		<form:errors path="*"  element="div"/>
		
		<input type="submit" value="zapisz autora">
	
	</form:form>

	
</body>
</html>