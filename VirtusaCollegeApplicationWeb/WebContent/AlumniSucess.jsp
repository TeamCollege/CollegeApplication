<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${operation}"/></title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>

<div style="background-color: #CCC;width:100px;height:100px;">
<p align="center"><c:out value="${operation}"/></p>
</div>
<table>
<tr>
<th>Alumni Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>PhoneNumber</th><th>gender</th><th>Present Status</th><th>Year Of Completion</th>
</tr>
<tr>
<td><c:out value="${alumniModel.alumniId}"/></td>
<td><c:out value="${ alumniModel .firstName}"/></td>
<td><c:out value="${ alumniModel .lastName}"/></td>
<td><c:out value="${ alumniModel.email}"/></td>
<td><c:out value="${ alumniModel.phoneNumber}"/></td>
<td><c:out value="${ alumniModel.gender}"/></td>
<td><c:out value="${ alumniModel .presentStatus}"/></td>
<td><c:out value="${ alumniModel .yearOfCompletion}"/></td>


</tr>
</table>
</body> 
</html>
