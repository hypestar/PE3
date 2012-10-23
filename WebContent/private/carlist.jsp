<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="carlist" class="dk.stacktrace.pe3.beans.CarList" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car List</title>
</head>
<body>
<h1>Car List</h1>
<jsp:getProperty property="carListTable" name="carlist"/>
</body>
</html>