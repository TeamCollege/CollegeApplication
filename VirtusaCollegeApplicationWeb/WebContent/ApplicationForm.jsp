<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Form</title>
<link href="css/form.css" rel="stylesheet"/>

</head>
<body>
<div align="center">
<form method="post" action="user?action=loadadmissionsform">
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
<td><label for="tenthPercentage">Tenth Percentage:</label></td>
<td><input type="number" step="any" name="tenthPercentage"/></td>
</tr>

<tr>
<td><label for="interPercentage">Inter Percentage:</label></td>
<td><input type="number" step="any" name="interPercentage"/></td>
</tr>

<tr>
<td><label for="aadharNumber">Aadhar Number:</label></td>
<td><input type="number" name="aadharNumber"/></td>
</tr>

<tr>
<td><label for="dateOfBirth">Date Of Birth:</label></td>
<td><input type="date" name="dateOfBirth"/></td>
</tr>

<tr>
<td><label for="dateOfBirth">Date Of Birth:</label></td>
<td><input type="date" name="dateOfBirth"/></td>
</tr>

<tr>
<td><label for="departmentName">Department Name:</label></td>
<td>
<select name="departmentName">
<option value="cse"><c:out value="Computer Science and Engineering"/></option>
<option value="ece"><c:out value="Electronics and Communication Engineering"/></option>
<option value="eee"><c:out value="Electrical and Electronical Engineering"/></option>
</select>
</td>
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