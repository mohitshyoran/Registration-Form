<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<body>
 <div align="center">
  <h1>Admin Form</h1>
  <form action="<%= request.getContextPath() %>/admin" method="post">
   <table style="with: 80%">
   <tr>
     <td>Admin ID</td>
     <td><input type="number" name="adminID" /></td>
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
     <td>Password</td>
     <td><input type="text" name="password" /></td>
    </tr>
	</table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>