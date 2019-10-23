<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
    <%@include file="Main.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student View </title>
<style>
a:link, a:visited {
  background-color:black;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color:grey ;
}
</style>
</head>
<body align="center"  background="">

<h1> Student View </h1> <br><br><br>
<a href="classdepartments.html"><b>View Class Schedule</b> </a><br><br>
<a href="examdepartments.html"><b> View Exam Schedule</b> </a><br><br>
<a href="resultsstudent.html"><b>View Results</b></a><br><br>
<a href="uploaddownload.html"><b>Upload and Download Assignments</b></a><br><br>
<a href="StudentControllerServlet?action=viewplacementcalender"><b>View Placement Calender</b></a><br><br>
<a href="generalexams.html"><b>Practice Exams</b></a><br><br>
<a href="login.html"> <b>logout </b></a><br>
</body>
</html>