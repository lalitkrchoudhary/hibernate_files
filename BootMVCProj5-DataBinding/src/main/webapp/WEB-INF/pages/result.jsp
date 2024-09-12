<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResultPage</title>
</head>
<body>

<center>
<h1>The details are</h1>
<table border="1">
<tr>
<th>ENO</th>
<td>${employee.eno}</td>
</tr>

<tr>
<th>ENAME</th>
<td>${employee.ename}</td>
</tr>

<tr>
<th>EDESG</th>
<td>${employee.edesg}</td>
</tr>

<tr>
<th>SALARY</th>
<td>${employee.salary}</td>
</tr>
</table>
</center>
</body>
</html>