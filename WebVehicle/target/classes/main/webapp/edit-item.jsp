<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
<form action ="editVehicleServlet"method="post">
Make: <input type ="text" name ="make" value="${vehicleToEdit.make}">
Model: <input type ="text" name ="model" value="${vehicleToEdit.model}">
<input type ="hidden" name ="serialNumber" value="${vehiclieToEdit.serialNumber}">
<input type ="submit" value="Save Edited Item">
</form>
</body>
</html>