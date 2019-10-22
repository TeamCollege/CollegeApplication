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
<h1 align="center">Class Schedule Details</h1><br><br><br>

<table align="center">
<tr>
<th>Day</th>
<th>First Hour</th>
<th>Second Hour</th>
<th>Third Hour</th>
<th>Fourth Hour</th>
</tr>

<c:forEach items="${classScheduleModelList}" var="classschedule">
<tr>
<td><c:out value="${classschedule.day}"/></td>
<td><c:out value="${classschedule.firstHour}"/></td>
<td><c:out value="${classschedule.secondHour}"/></td>
<td><c:out value="${classschedule.thirdHour}"/></td>
<td><c:out value="${classschedule.fourthHour}"/></td>

</tr>
</c:forEach>
</table><br><br><br><br>
<a href="student.jsp">Back</a> 
</body>
</html>