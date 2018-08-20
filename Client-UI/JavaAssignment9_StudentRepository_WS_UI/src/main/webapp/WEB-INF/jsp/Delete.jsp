

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Try1.css">
<script type="text/javascript" src="Registration.js"></script>
<title>Student Management System</title>
</head>
<body>

	<div id="header">
		<h1 style="font-size: 40px; padding-left: 230px;">Student
			Management System</h1>
	</div>
	<center>
		<br>
		<br>
		<br>
		<br>

		<div id="set">
			<div id="set2">
				<h2>
					<marquee behavior="alternate">Student Deletion</marquee>
				</h2>
			</div>
			<br>

			<form name="ContactForm" action="DeleteServlet" method="POST">

				<label>User Name</label> <input type="text" id="username"
					name="username" placeholder="Enter username to delete  "><br>
                <label>${deleteFailureMessage}</label>

				<input id="sub" type="submit" value="Delete">
				<input id="sub1" type="reset" name="Clear"><br> <br>    
				<br>
			</form>
		</div>
	</center>
</body>
</html>