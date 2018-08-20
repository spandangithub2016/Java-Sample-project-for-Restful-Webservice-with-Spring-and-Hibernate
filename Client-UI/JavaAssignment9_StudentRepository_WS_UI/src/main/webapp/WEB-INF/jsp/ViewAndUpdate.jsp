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
                <h2><marquee direction=RIGHT>Update Details</marquee></h2>
            </div>
            <br>
            <form name="ContactForm"  action="UpdateServlet" method="POST">
            
                
                <label>Full Name</label>
                <input type="text" id="fullname" name="fullname" value="${fullname}"><br>

                <label>User Name</label>
                <input type="text" id="username" name="username" value="${username}" readonly="readonly"><br>
                
                <label>Password</label>
                <input type="text" id="password" name="password" value="${password}"><br>
                
                <label>Adress</label>
                <input type="text" id="address" name="address" value="${address}"><br> 
 
                <label>Date Of Birth (dd/mm/yy)</label>
                <input type="Date" id="dob" name="dob" value="${dob}"><br><br>

                <label>Gender</label>
                <select name="gender" >
                    <option>--Select--</option>
                    <option id="male" value="Male">Male</option>
                    <option id="female" value="Female">Female</option>
                </select>

                <label>Contact</label>
                <input type="text" id="phone" name="phone" value="${contact}"><br>

                <label>Email</label>
                <input type="text" id="email" name="email" value="${email}"><br>

                <label>City</label>
                <input type="text" id="city" name="city" value="${city}"><br>

                <label>State</label>
                <input type="text" id="lname" name="state" value="${state}"><br>

                <label>Country</label>
                <select name="country">
                <option>--Select--</option>
                    <option value="india">India</option>
                    <option value="canada">Canada</option>
                    <option value="usa">USA</option>
                </select>
                <br><br><br><br>
    
                <div id="set2">
                    <h2><marquee DIRECTION=right>Course Details</marquee></h2>
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
                <input type="text" id="cid" name="cid" value="${courseid}" readonly="readonly"><br>

                <label>Course Fees</label>
                <input type="text" id="fees" name="fees" value="${fees}" readonly="readonly"><br>

                <label>Course Duration</label>
                <input type="text" id="duration" name="duration"value="${duration}" readonly="readonly"><br> 

                <br><br><br><br>

                <input id="sub" type="submit" value="Update" >
                <input id="sub1" type="reset" value="Reset"><br>
                <br><br>
            </form>
        </div>
    </center>
</body>
</html>