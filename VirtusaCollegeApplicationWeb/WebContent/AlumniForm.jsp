<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni Registration Form</title>
<link href="css/form.css" rel="stylesheet"/>

 

</head>
<body>
<div align="center">
<form method="post" action="alumni?action=loadregistrationform">
<table>

 

<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName"/>&nbsp;<label style="color:red"><c:out value="${firstnameerror}"/></label></td>
</tr>

 

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>

 

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>

 

<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber"/></td>
</tr>

<tr>
<td><label for="gender">Gender:</label></td>
<td>
<select name="gender">
<option value="female"><c:out value="Female"/></option>
<option value="male"><c:out value="Male"/></option>
</select>
</td>
</tr>

<tr>
<td><label for="presentStatus">Present Status:</label></td>
<td>
<select name="presentStatus">
<option value="employed"><c:out value="Employed"/></option>
<option value="higherStudies"><c:out value="Higher Studies"/></option>
</select>
</td>
</tr>

<tr>
<td><label for="yearOfCompletion">Year Of Completion:</label></td>
<td><input type="number" name=""/>yearOfCompletion</td>
</tr>

<tr>
<td><input type="submit" value="Register" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>