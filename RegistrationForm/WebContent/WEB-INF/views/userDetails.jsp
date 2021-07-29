<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Portal</title>
</head>
<body>
 <div align="center">
  <h1>Registration Form</h1>
  <form action="<%= request.getContextPath() %>/user" method="post">
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
     <td>Phone No</td>
     <td><input type="number" name="phoneNo" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Date</td>
     <td><input type="date" name="date" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Upload Photo</td>
     <td><input type="file" name="photo" /></td>
    </tr>
	</table>
   <input type="submit" value="Register" />
  </form>
 </div>
</body>
</html>