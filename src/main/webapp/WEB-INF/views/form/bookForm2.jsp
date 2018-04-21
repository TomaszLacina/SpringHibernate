<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Super formularz</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>
	
	<form:form method="post" modelAttribute="book">
		<form:input path="title"/>
		<form:select path="publisher.id" 
			 items="${publisherItems}"
			 itemValue="id" 
             itemLabel="name"/>
        
		<form:input path="rating"/>
		
		<form:select 
			multiple="true" 
			path="authors"
			items="${authorItems}"
			itemValue="id" 
            itemLabel="name">
		</form:select>
		
		<form:input path="description" cssClass="error"/>
		<form:input path="pages" cssClass="error"/>
	
		<form:errors path="title" cssClass="error" element="div"/>
		<form:errors path="authors" cssClass="error" element="div"/>
		<form:errors path="rating" cssClass="error" element="div"/>
		<form:errors path="publisher" cssClass="error" element="div"/>
		<form:errors path="title" cssClass="error" element="div"/>
		
		<input type="submit" value="zapisz ksiazke">
	
	</form:form>

	
</body>
</html>