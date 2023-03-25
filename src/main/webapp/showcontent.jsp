<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  	<%@page import="java.util.*" %>
	<%@page import="com.example.demo.model.*" %>
 
    <%@page import="java.nio.file.Files" %>
    <%@page import="java.io.File" %>
    <%@page import="java.util.Base64.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Subject> es=(List<Subject>)request.getAttribute("list"); %>

<table border="1">
<tr><th>Subject ID</th><th>Sub_Name</th><th>Sub_Stream</th><th>Sub_Pic</th></tr>
<%for(Subject e:es){%>
<tr><td><%=e.getId() %></td><td><%=e.getName() %></td><td><%=e.getStream()%></td><td>
<%String path=e.getFilePath();
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<img alt="img" src="data:image/png;base64,<%=base64Encoded%>" width="100" height="100"/>
</td><td>
<form action="delete">
<input type="hidden" name="subid" value=<%=e.getId()%> >
<input type="submit" value="Delete">
</form></td>
<td>
<form action="edit">
<input type="hidden" name="subid" value=<%=e.getId()%>>
<input type="submit" value="Edit">
</form></td>
</tr>
<%}%>
</table>
</body>
</html>