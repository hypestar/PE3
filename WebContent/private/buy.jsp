<%@page import="dk.stacktrace.pe3.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart"); 
        String carId = (String)request.getParameter("carId");
        cart.buyCar(carId);
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buy Car</title>
</head>
<body>
<h1>Shopping Cart</h1>
<%=cart.getShoppingCartTable()%>

<a href="carlist.jsp"></a>
</body>
</html>