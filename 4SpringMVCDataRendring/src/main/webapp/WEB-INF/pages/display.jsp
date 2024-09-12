<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayPage</title>
</head>
<body>
<h1>The data is here::</h1>
<br>
<h2>
The name is: ${name}
The age is: ${age}
The address is: ${address}

</h2>

<hr>
<h1>Game name are::</h1>
<c:forEach var="game" items="gameNames">
<li>${game}</li>
</c:forEach>
${gameNames}

<hr>
<h2>${subjectList}</h2>

<hr>
<h2>${mobileSet}</h2>

<hr>
<h2>${idsMap}</h2>
</body>
</html>