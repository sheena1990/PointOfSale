
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.pos.dto.ItemDto" import = "java.util.List " import="com.pos.dto.DiscountListDto"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salesman</title>
</head>
<body>
<center>
<%String msg = (String)request.getAttribute("msg");
String loyaltyStatusMsg=(String)request.getAttribute("loyaltyStatusMsg");
String loyaltyPointsStatus=(String)request.getAttribute("loyaltyPointsStatus");
Integer loyaltyPointsToBeRedeemed=(Integer)request.getAttribute("loyaltyPointsToBeRedeemed");

%>
<font color="red">${requestScope.msg}</font>
<br>
<form action="POSServlet" method="post">
Enter item id: <input type="text" name="itemId"/> 
<input type="submit" value="Add" name="op"/><br><br>
<input type="submit" value="Done" name="op"/>
<% if(loyaltyStatusMsg!=null || loyaltyPointsStatus!=null){%>
<input type="submit" value="ProcessLoyalty" name="op"/>
<input type="submit" value="ProcessOrder" name="op">
<input type="submit" value="Pay" name="op"/>
<%} %>
</form>
<br>
<br>
<font >${requestScope.loyaltyStatusMsg}</font>
<font >${requestScope.loyaltyPointsStatus}</font>
<font >${requestScope.loyaltyPointsToBeRedeemed}</font>
<br>
<br>

<table border=1 bgcolor="blue">
<tr bgcolor="gray">
	<td>Item Id</td>
	<td>Item Name</td>
	<td>Unit Price</td>		
</tr>

<% 

List<ItemDto> itemDtoList = (List<ItemDto>)session.getAttribute("itemDtoList");
if (itemDtoList != null) {
	
for(ItemDto itemDto : itemDtoList){ %>
<tr bgcolor="seagreen">
<td><%= itemDto.getItemId() %></td>
<td><%= itemDto.getItemName() %></td>
<td><%= itemDto.getUnitPrice() %></td>
 </tr>
<%
}
}
%>
</table>
<br>
<br>

<table border=1 bgcolor="blue">
<tr bgcolor="gray">
	<td>Item Id</td>
	<td>Item Name</td>
	<td>Unit Price</td>
	<td>Discount Percent</td>	
</tr>

<% 

List<DiscountListDto> discountedItemDtoList = (List<DiscountListDto>)session.getAttribute("discountedItemDtoList");
if ( discountedItemDtoList!= null) {
	
for( DiscountListDto discounteListDto : discountedItemDtoList){ %>
<tr bgcolor="seagreen">
<td><%= discounteListDto.getItemDto().getItemId() %></td>
<td><%= discounteListDto.getItemDto().getItemName() %></td>
<td><%= discounteListDto.getItemDto().getUnitPrice() %></td>
<td><%= discounteListDto.getDiscountPercent() %></td>
 </tr>
<%
}
}
%>
</table>

</center>
</body>
</html>