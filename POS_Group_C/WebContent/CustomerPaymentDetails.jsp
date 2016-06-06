<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer payment details</title>
</head>
<body>
	<center>

		<form action="PaymentServlet" method="post">
		
			<input type="radio" name="paymentMode" value="cash"/> cash <br>
			<input type="radio" name="paymentMode" value="debit card"/> debit card <br>
			<input type="radio" name="paymentMode" value="credit card"/> credit card <br>
		
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<font color="red">${requestScope.msg}</font>
			
			<%String statusMsg = (String)request.getAttribute("statusMsg");
			if(statusMsg==null){ %>
			<Br>Enter card number: <input
				type="text" name="CardNumber" /> <br>
			<br> Enter CVV number: <input type="password" name="CVVNumber" />
			<br>
			<br> Enter pin code: <input type="password" name="pinCode" /> <br>
			<br> Enter expiry date: <input type="text" name="expiryDate" />
			<br>
		
			<br> <input type="reset" name="reset" value="reset" />

<input type="submit" name="submit" value="submit" />
<%} %>

		</form>
	</center>
</body>
</html>