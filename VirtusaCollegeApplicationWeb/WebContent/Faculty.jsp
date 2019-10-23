<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
    <%@include file="Main.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Homepage</title>
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

<h1> Faculty Homepage</h1> <br><br><br>
<a href="FacultyDepartments.html"><b>Class Schedule</b> </a><br><br>
<a href="FacultyExamDepartment.html"><b>Exam Schedule</b> </a><br><br>
<a href="StaffMeeting.html"><b>Staff Meeting</b></a><br><br>
<a href="student?action=assignments"><b>Upload and Download Assignments</b></a><br><br>
<a href="demohtml.html"><b>View Placement Calender</b></a><br><br>
<a href="generalexams.html"><b>Practice Exams</b></a><br><br>
<a href="student?action=logout"> <b>logout </b></a><br>
</body>
</html>