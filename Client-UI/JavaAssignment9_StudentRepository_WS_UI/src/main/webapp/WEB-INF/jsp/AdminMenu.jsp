<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Try1.css">
<script type="text/javascript" src="Registration.js"></script>
<title>Student Management System</title>

<style type="text/css">


.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 25px;
    margin: 4px 2px;
    cursor: pointer;
}
.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}



</style>

</head>
<body>
    
    <div id="header"><h1 style="font-size: 40px; padding-left: 230px; ">Student Management System</h1></div>
    <center>
    <br><br><br><br>   
        
        <div id="set">
            <div id="set2">
                <h2><marquee behavior="alternate">Admin Menu</marquee></h2>
            </div>
            <br>

                <a href="RegistrationJsp" class="button button2">Add Student</a>                
                <a href="DeleteJsp" class="button button2">Delete Student</a>
                <br>
                <a href="LoginJsp" class="button button2">Log Out</a>
                 
        </div>
    </center>
</body>
</html>