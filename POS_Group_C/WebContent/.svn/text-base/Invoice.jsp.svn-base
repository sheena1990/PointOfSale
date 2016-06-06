<%@page import="com.pos.dto.ItemDto"%>
<%@page import="com.pos.dto.InvoiceItemDto"%>
<%@page import="com.pos.dto.InvoiceDto"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display invoice</title>
</head>
<body>
<center>
<%InvoiceDto invoiceDto=(InvoiceDto)request.getAttribute("InvoiceDto");%>
<form action="POSServlet" method="post">
<br>
<br>
<%if(invoiceDto!=null){ %>
<table>
<tr bgcolor="yellow">
<th>Date:</th>
<td>Date:&nbsp;&nbsp;<%= invoiceDto.getDate()%></td>
</tr>
<tr></tr>
<tr></tr>
<tr bgcolor="grey">
<td>Name</td>
<td>Price</td>
<td>Discount Percent</td>
<td>Amount</td>
</tr>
<tr></tr>
<tr></tr>
<% List<InvoiceItemDto> invoiceItemDtoList=invoiceDto.getInvoiceItemDtoList();
for(InvoiceItemDto invoiceItemDto:invoiceItemDtoList) {%>
<tr bgcolor="magenta">
<td><%= invoiceItemDto.getName()%></td>
<td><%= invoiceItemDto.getPrice() %></td>
<td><%= invoiceItemDto.getDiscountPercent()%></td>
<td><%= invoiceItemDto.getAmount()%></td>
</tr>
<%} %>
<tr>
<td></td>
<td></td>
<td></td>
<td><%= invoiceDto.getTotalAmount()%></td>
</tr>
</table>
<%} %>
</form>
</center>
</body>
</html>