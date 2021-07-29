<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Portal</title>
</head>
<body>
 <div align="center">
  <h1>Course Form</h1>
  <form action="<%= request.getContextPath() %>/course" method="post">
   <table style="with: 80%">
   <tr>
     <td>Course ID</td>
     <td><input type="number" name="courseID" /></td>
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr >
     <td>Description</td>
     <td ><input type="text" name="desp" /></td>
    </tr>
    <tr>
     <td>Fees</td>
     <td><input type="text" name="fees" /></td>
    </tr>
    <tr>
     <td>Course Resources</td>
     <td><input type="file" name="resource" /></td>
    </tr>
	</table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>