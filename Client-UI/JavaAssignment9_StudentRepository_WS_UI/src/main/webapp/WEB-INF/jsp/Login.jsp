
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Try1.css">
<title>Student Management System</title>
</head>
<body>
    
    <div id="header"><h1 style="font-size: 40px; padding-left: 230px; ">Student Management System</h1></div>
    <center>
    <br><br><br><br>   
        
        <div id="set">
            <div id="set2">
                <h2><marquee behavior="alternate">Input Credentials</marquee></h2>
            </div>
            <br>

            <form name="ContactForm"  action="LoginServlet" method="POST">

                <label>User Name</label>
                <input type="text" id="username" name="username" placeholder="Enter username here.." ><br>
                
                <label>Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password here.." ><br>

                <br><br><br><br>
                

                <input id="sub" type="submit" value="Login" >
                <input id="sub1" type="reset" name="reset"><br>
                <br><br>
            </form>
        </div>
        
    </center>
</body>
</html>