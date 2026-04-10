<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment Registration</title>
</head>
<body>

<span class="text-success">${msg}</span>
<form action="pat" method="post">

Name:
	<input type="text"  placeholder="Enter Patient Name"  	required>
	<br>
	<br>
	Treatment:
	<select  name = " Treatment"> 	
	<option value = "cleaning">Cleaning</option>
	<option value= "Filling">filling</option>
	<option value="Root Canal">RoolCanal</option>
	</select>
	<br>
	<br>
	Date:
	<input type="date" name="date" required>
	<br>
<br>
<input type="submit" value = "Book Appointment"> 
	
</form>

</body>
</html>