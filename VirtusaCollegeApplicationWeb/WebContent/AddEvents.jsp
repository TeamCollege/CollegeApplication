<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="admin" method="post" autocomplete="off" >
 
 <div class="container">
 			<h1 align="center">Add Events</h1>
			<table style="with: 50%">
				<tr>
					<td>Event Name</td>
					<td>:</td>
					<td><input type="text" name="event_name" required/></td>
				</tr>
				<tr>
					<td>Event date</td>
					<td>:</td>
					<td><input type="date" name="event_date" required/></td>
				</tr>
				<tr>
					<td>Event Location</td>
					<td>:</td>
					<td><input type="text" name="location" required/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="button" value="Submit" >
				</div> 
				</form>
</body>
</html>