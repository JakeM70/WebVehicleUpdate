<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allVehicles}" var="currentvehicle">
<tr>
<td><input type="radio" name="serialNumber" value="${currentvehicle.serialNumber}"></td>
<td>${currentvehicle.make}</td>
<td>${currentvehicle.model}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name= "doThisToVehicle">
<input type = "submit" value = "delete" name= "doThisToVehicle">
<input type = "submit" value = "add" name = "doThisToVehicle">
</form>
</body>
</html>