<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Super lista</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Lista</h1>

	<form:form method="post" modelAttribute="book">
		<form:input path="title" />
		<form:input path="rating" />
		<form:select path="publisher.id" 
			 items="${publishers}"
             itemValue="id" 
             itemLabel="name"/>
		<input type="submit" value="Save">
	</form:form>



</body>
</html>