<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Portal</title>
</head>
<body>
 <div align="center">
  <h1>Contact Form</h1>
  <form action="<%= request.getContextPath() %>/contact" method="post">
   <table style="with: 80%">
   <tr>
     <td>User ID</td>
     <td><input type="number" name="userID" /></td>
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Phone No</td>
     <td><input type="number" name="phoneNo" /></td>
    </tr>
    <tr>
     <td>Message</td>
     <td><input type="text" name="message" /></td>
    </tr>
    <tr>
     <td>Contact ID</td>
     <td><input type="number" name="contactID" /></td>
    </tr>
	</table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>