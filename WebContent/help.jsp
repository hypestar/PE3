<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mike's Miniature Models</title>
</head>
<body>
<%
ServletContext context = getServletContext();
String author = context.getInitParameter("author");
String version = context.getInitParameter("version");
String date = context.getInitParameter("date");
%>
<h1>Help</h1>
<p> Author : <%=author%><br>
Version : <%=version %><br>
Last updated : <%=date%>
</p>
</body>
</html>