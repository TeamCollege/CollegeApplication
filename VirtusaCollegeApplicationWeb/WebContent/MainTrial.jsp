<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: black;
    color:smokewhite;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {

    display: none;
    padding: 6px 12px;
    border: 5px solid #ccc;
    border-top: none;
}
   body{
                margin-top: 30px;
                background-image: url("back.jpg");
                background-size: 1520px;
                color: whitesmoke;
            }
             .btn-login
            {
                align-content: center;
                border-radius: 4px;
                border: none;
                color: whitesmoke;
                padding: 6px 25px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 18px;
                margin-left: 10px;
                background-color:grey;
            }
              a:hover{
                color: red;
            }
</style>
</head>
<body align="center">
    
        <h2><p align="center">VIRTUSAN UNIVERSITY</p></h2>


<div class="tab">
<a href="collegedetails.html"><button class="tablinks"> College Details</button></a>
<a href="user?action=loadadmissionsform"><button class="tablinks"> Admissions</button></a>
<a href="login.html"><button class="tablinks"> Login</button></a>
<a href="alumni.html"><button class="tablinks"> Alumni Registrations</button></a>
<a href="News.html"><button class="tablinks">News </button></a>
<a href="feedback.html"><button class="tablinks"> Feedback</button></a>
 <!--  <button class="tablinks" onclick="openpage(event, 'uploaddocuments')">UPLOAD DOCUMENTS</button>
    <a href="viewdocuments.jsp"> <button class="tablinks" onclick="openpage(event, 'viewdocuments')">VIEW DOCUMENTS</button></a>
  <a href="classdepartments.html"><button class="tablinks"> </button></a>
     <a href="imgview.jsp"><button class="tablinks" onclick="openpage(event, 'viewphotos')"> VIEW PHOTOS</button></a>
     <form action="view.jsp"> <button class="tablinks" onclick="openpage(event, 'editdetails')" align="right">VIEW DETAILS</button></form>
 -->
<a href ="login.html"><p align="right"><input type="submit" value="LOGOUT"  class="btn-login" /></p></a>
</div>

</body>
</html>