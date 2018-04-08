<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Super formularz</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>
	
<%-- 	<form method="POST">
		<input type="text" name="login">
		<input type="password" name="password">
		<input type="text" name="email">
		
		<input type="submit">
	</form>
	 --%>
	
	
	<form:form method="POST" modelAttribute="person">
		<form:input path="login" />
		<form:password path="password"/>
		<form:input path="email"/>
		<form:input path="firstName"/>
		<form:input path="lastName"/>
		<form:radiobuttons items="${genders}" path="gender" />
		<form:select path="country" items="${countryItems}" />
		<form:textarea path="notes"/>
		<form:checkbox path="mailingList"/>
		<form:select path="programmingSkills" items="${skillItems}" />
		<form:checkboxes path="hobbies" items="${hobbyItems}"/>
		
		<input type="submit" value="save">	
	</form:form> 
	
</body>
</html>