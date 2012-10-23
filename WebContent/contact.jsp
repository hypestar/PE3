<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
</head>
<body>
<form action="http://java4web.dk:8080/PE3/SendMail" method="post">

<table>
<tr>
<td>Your name</td> <td><input type="text" size="20" name="username"></td>
</tr>
<tr>
<td>Your email</td><td><input type="email" size="20" name="from"></td>
</tr>
<tr>
<td>Subject</td><td><input type="text" size="20" name="subject"></td>
</tr>
<tr>
<td>Message</td><td><textarea rows="10" cols="19" name="message"> </textarea></td>
</tr>
<tr>
<td></td><td align="center"><input type="submit" value="send"></td>
</tr>
</table>


</form>
</body>
</html>