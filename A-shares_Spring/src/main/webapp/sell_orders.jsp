<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.Share_Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<%
Share_Order S_O =(Share_Order)session.getAttribute("S_O");
%>
<body>
<form action="sellOrder_submit" method="post">
<table width="400" align="center">
	<tr>
		<td colspan="2" align="center">芥虫獺</td>
	<tr>
		<td>眀め</td>
		<td><%=S_O.getAccount() %></td>
	<tr>
		<td>布嘿</td>
		<td><%=S_O.getCompany() %></td>
	<tr>
		<td>布腹</td>
		<td><%=S_O.getCode() %></td>
	<tr>
		<td>布瞷基</td>
		<td><%=S_O.getPrice() %></td>
	<tr>
		<td>本虫基</td>
		<td><%=S_O.getLimit_price() %></td>
	<tr>
		<td>本虫も计</td>
		<td><%=S_O.getQuantity() %></td>
	<tr>
		<td><input type="submit" value="芥虫癳"></td></br>
		<td><input type ="button" onclick="history.back()" value=""></input></td>
		
</body>
</html>