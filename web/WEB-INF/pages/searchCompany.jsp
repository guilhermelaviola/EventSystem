<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Development - JSP & Servlet</title>
</head>
<body>
	<h3>Search result:</h3>
	<ul>
		<c:forEach var="company" items="${companies}">
			<li>${company.id} : ${company.name}</li>
		</c:forEach>
	</ul>
</body>
</html>
