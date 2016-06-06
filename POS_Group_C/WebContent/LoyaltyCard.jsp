<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String msg=(String)request.getAttribute("msg"); %>
<font color="red">${requestScope.msg}</font>
<form action="LoyaltyCardServlet"  method="post">
<table border=1 bgcolor="blue" align="center">
<tr>
<th>LoyaltyCard Id: </th>
<td><input type="text" name="loyaltyCardId"></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<th>Enter Points To Be Redeemed: </th>
<td><input type="text" name="loyaltyPoints"></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<td></td>
<td><input type="submit" name="op" value="submitLoyaltyCardDetails"></td>
</tr>
</table>
</form>
</body>
</html>