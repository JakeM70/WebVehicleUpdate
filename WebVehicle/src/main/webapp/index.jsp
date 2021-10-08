<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="addVehicleServlet"method="post">
Make: <input type ="text" name="make">
Model: <input type ="text"name ="model">
<input type ="submit"value="Add Item">
</form>
<br />

<a href ="viewAllVehiclesServlet">View the complete list</a>
<a href="viewAllVehicleListsServlet">View all vehicle lists</a> <br />
<a href="addVehiclesForListServlet">Create a new list</a>
</body>
</html>