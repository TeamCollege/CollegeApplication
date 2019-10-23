<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@include file="taglib.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet"/>

</head>
<body background="" align="center"><br><br><br>
<h1 align="center">Results Details</h1><br><br><br>

<table border=2 align="center">
<tr>
<th>Placement ID</th>
<th>Company Name</th>
<th>Date</th>
<th>Location</th>
<th>Eligibility Criteria</th>
</tr>

<c:forEach items="${placementCalenderModelList}" var="placement">
<tr>
<td><c:out value="${placement.placementId}"/></td>
<td><c:out value="${placement.companyName}"/></td>
<td><c:out value="${placement.location}"/></td>
<td><c:out value="${placement.date}"/></td>
<td><c:out value="${placement.eligibilityCriteria}"/></td>


</tr>
</c:forEach>
</table><br><br><br><br>
<a href="student.jsp">Back</a> 
</body>
</html>