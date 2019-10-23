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
<h1 align="center">Exam Schedule Details</h1><br><br><br>

<table border=2 align="center">
<tr>
<th>Exam Date</th>
<th>Exam Type</th>
<th>Exam Name</th>
<th>Exam Subject 1</th>
<th>Exam Subject 2</th>
</tr>

<c:forEach items="${examScheduleModelList}" var="examschedule">
<tr>
<td><c:out value="${examschedule.examDate}"/></td>
<td><c:out value="${examschedule.examType}"/></td>
<td><c:out value="${examschedule.examName}"/></td>
<td><c:out value="${examschedule.examSubject1}"/></td>
<td><c:out value="${examschedule.examSubject2}"/></td>

</tr>
</c:forEach>
</table><br><br><br><br>
<a href="student.jsp">Back</a> 
</body>
</html>