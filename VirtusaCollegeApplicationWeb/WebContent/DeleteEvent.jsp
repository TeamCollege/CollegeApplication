<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="DeleteEventsServlet" method="post" autocomplete="off" >
 
 <div class="container">
 			<h1 align="center">Delete Events</h1>
			<table style="with: 50%">
				<tr>
					<td>Event Id</td>
					<td>:</td>
					<td><input type="number" name="event_Id" required/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="button" value="Submit" ></td>
				</tr>
				</div> 
				</form>
</body>
</html>