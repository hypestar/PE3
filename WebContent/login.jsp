<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	if (session.getAttribute("username") != null) {
		String redirectURL = "/private/main.jsp";
		response.sendRedirect(redirectURL);
	}
%>

<%
	String cookieName = "username";
	Cookie cookies[] = request.getCookies();
	Cookie myCookie = null;
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(cookieName)) {
				myCookie = cookies[i];
				break;
			}
		}
	}
%>

<title>PE3 - login page</title>
</head>
<body>
	<form action="http://java4web.dk:8080/PE3/Login" method="post">
		Username : <input type="text" name="username" size="20"
			<%if (myCookie != null) {%> value=<%=myCookie.getValue()%> <%}%>><br>
		Password : <input type="password" name="password"><br>
		Remember my username <input type="checkbox" name="remember_username"
			checked="checked" value="true"><br> <input type="submit"
			value="Login">
	</form>
</body>
</html>