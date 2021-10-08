<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method= "post">
List Name: <input type = "text" name = "listName"><br />
Trip date: <input type = "text" name ="month" placeholder= "mm" size= "4">
<input type = "text" name = "day" placeholder= "dd" size= "4">, 
<input type = "text" name = "year" placeholder= "yyyy" size= "4">
Buyer Name: <input type = "text" name = "buyerName"><br />

Available Vehicles:<br />
<select name= "allItemsToAdd" multiple size= "6">
<c:forEach items= "${requestScope.allVehicles}" var= "currentitem">
<option value = "${currentitem.serialNumber}">${currentitem.make} | ${currentitem.model}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value= "Create List and Add Items">
<a href ="index.jsp">Go add new items instead.</a>
</form>
</body>
</html>