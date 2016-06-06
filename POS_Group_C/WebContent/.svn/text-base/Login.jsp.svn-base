<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Screen</title>

</head>
<body>
	<h1 align="center" >Welcome To Our POS System</h1>
	
		<table width="100%" height="100%">
		<tr>
			<td align="center" width="50%">
			<img src="Water lilies.jpg">	
			</td>
			<td align="center" width="50%">
			<form action="POSServlet" method="post">
				Login id: <input type="text" name="loginId"><br><br><br>
				Password: <input type="password" name="password"><br> <br><input
					type="submit" value="login" name="op">     <input
					type="reset" value="reset" name="Reset">
			</form>
			<%String msg=(String)request.getAttribute("msg");	%>		
			  
			<font color="red">${requestScope.msg} </font>
			
			
			
			
			
			</td>
			</tr>
	</table>

</body>
</html>