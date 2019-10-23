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
<th>Student ID</th>
<th>Subject1 Name</th>
<th>Subject1 Marks</th>
<th>Subject2 Name</th>
<th>Subject2 Marks</th>
<th>Pass/Fail</th>
</tr>

<c:forEach items="${resultsModelList}" var="results">
<tr>
<td><c:out value="${results.studentId}"/></td>
<td><c:out value="${results.subject1Name}"/></td>
<td><c:out value="${results.subject1Marks}"/></td>
<td><c:out value="${results.subject2Name}"/></td>
<td><c:out value="${results.subject2Marks}"/></td>
<td><c:out value="${results.finalresult}"/></td>

</tr>
</c:forEach>
</table><br><br><br><br>
<a href="student.jsp">Back</a> 
</body>
</html>