<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Subject Detail Form</title>
</head>
<body>
<form action="insert" method="post" enctype="multipart/form-data">
<table>
<tr><td>Subject id</td><td><input type="text" name="subid"><br></td></tr>
<tr><td>Subject name</td><td><input type="text" name="subname"><br></td></tr>
<tr><td>Subject stream</td><td><input type="text" name="substr"><br></td></tr>
<tr><td>Sub picture</td><td><input type="file" name="file"><br></td></tr>
<tr><td><input type="submit" value="Insert"><br></td></tr>
</table>
</form><br>
<form action="getall">
<input type="submit" value="Display Contents">
</form>


</body>
</html>