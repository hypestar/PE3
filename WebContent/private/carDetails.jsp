<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cardetails" class="dk.stacktrace.pe3.beans.CarDetails"/>
<jsp:setProperty property="*" name="cardetails"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Car Details</h1>
<jsp:getProperty property="carDetailsTable" name="cardetails"/>
</body>
</html>