<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<h2 align="center">Employees Contact Details</h2>
<div align="center">
<table>
<tr>
<th>Alumni Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone Number</th><th>Gender</th><th>Present Status</th><th>Year Of Completion</th>
</tr>

<c:forEach items="${alumniModelList}" var=”alumnimodel">
<tr>
<td><c:out value="${alumnimodel.alumniId}"/></td>
<td><c:out value="${alumnimodel.firstName}"/></td>
<td><c:out value="${alumnimodel.lastName}"/></td>
<td><c:out value="${alumnimodel.phoneNumber}"/></td>
<td><c:out value="${alumnimodel.email}"/></td>
<td><c:out value="${alumnimodel.gender}"/></td>
<td><c:out value="${alumnimodel.presentStatus}"/></td>
<td><c:out value="${alumnimodel.yearOfCompletion
}"/></td>





</tr>
</c:forEach>
</table>
</div>
</body>
</html>
