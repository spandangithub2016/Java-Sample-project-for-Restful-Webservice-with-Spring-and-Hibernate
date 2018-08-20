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
	
	<div id="header"><h1 style="font-size: 40px; padding-left: 230px; ">Student Management System</h1></div>
	<center>
	<br><br><br><br>   
		
		<div id="set">
			<div id="set2">
				<h2 style="font-size: 30px;"><marquee behavior="alternate">Student Registration Personal Details</marquee></h2>
			</div>
			<br>

			<form name="ContactForm"  action="RegistrationServlet" method="POST">
    			
                <label>Full Name</label>
    			<input type="text" id="fullname" name="fullname" placeholder="Enter name here.." ><br>

			    <label>User Name</label>
    			<input type="text" id="username" name="username" placeholder="Enter username here.." ><br>
				
				<label>Password</label>
    			<input type="password" id="password" name="password" placeholder="Enter password here.." ><br>
				
				
    			<label>Adress</label>
    			<input type="text" id="address" name="address" placeholder="Enter Adress here.." ><br> 
 
    			<label>Date Of Birth (dd/mm/yy)</label>
    			<input type="Date" id="dob" name="dob" ><br><br>

    			<label>Gender</label>
    			<select name="gender" >
    				<option>--Select--</option>
    				<option id="male" >Male</option>
    				<option id="female" >Female</option>
    			</select>

    			<label>Contact</label>
    			<input type="text" id="phone" name="phone" placeholder="Your Phone Number.."><br>

    			<label>Email</label>
    			<input type="text" id="email" name="email" placeholder="e.g. abc@xyz.com"><br>

      			<label>City</label>
    			<input type="text" id="city" name="city" placeholder="Your City.." ><br>

      			<label>State</label>
    			<input type="text" id="lname" name="state" placeholder="Your state.."><br>

    			<label>Country</label>
    			<select name="country">
    			<option>--Select--</option>
      				<option value="india">India</option>
      				<option value="canada">Canada</option>
      				<option value="usa">USA</option>
    			</select>
    			<br><br><br><br>
    
    			<div id="set2">
					<h2 style="font-size: 30px;"><marquee behavior="alternate">Student Registration Course Details</marquee></h2>
				</div>
				<br>

    			<label>Course Name</label>
    			<select name="course" id="course" onChange="delivery(this)">
    				<option>--Select--</option>
    				<option value='Msc'>Msc</option>
    				<option value='MCA'>MCA</option>
    				<option value='M.Tech'>M.Tech</option>
   					<option value='Phd'>Phd</option>
   				</select>
    			<label>Course ID</label>
    			<input type="text" id="cid" name="cid" placeholder="Course ID.."  ><br>

    			<label>Course Fees</label>
    			<input type="text" id="fees" name="fees" placeholder="Fees in INR" ><br>

    			<label>Course Duration</label>
    			<input type="text" id="duration" name="duration" placeholder="year of Course" ><br>	

    			
    			<input id="sub" type="submit" value="Submit" > <!-- onclick=" return ValidateContactForm();" -->
    			<input id="sub1" type="reset" name="reset"><br>
				<br><br>
  			</form>
		</div>
	</center>
</body>
</html>