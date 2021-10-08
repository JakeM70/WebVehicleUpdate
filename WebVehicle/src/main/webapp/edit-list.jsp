<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
<form action = "editVehicleListDetailsServlet" method= "post">
<input type = "hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type = "text" name = "vehicleListName" value= "${listToEdit.vehicleListName}"><br />
Trip date: <input type = "text" name = "month" placeholder= "mm" size= "4" value= "${month}"> 
<input type = "text" name = "day" placeholder= "dd" size= "4" value= " ${date}">, 
<input type = "text" name= "year" placeholder= "yyyy" size= "4" value= "${year}">
Buyer Name: <input type = "text" name = "buyerName" value= "${listToEdit.buyer.buyerName}"><br />
Available Vehicles:<br />
<select name= "allItemsToAdd" multiple size= "6">
<c:forEach items= "${requestScope.allVehicles}" var="currentitem">
<option value = "${currentitem.serialNumber}">${currentitem.make} | ${currentitem.model}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href ="index.jsp">Go add new vehicles instead.</a>
</body>
</html>