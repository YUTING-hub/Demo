<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.Share_Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<%
Share_Order S_O =(Share_Order)session.getAttribute("S_O");
%>
<body>
<form action="buyOrder_submit" method="post">
<table width="400" align="center">
	<tr>
		<td colspan="2" align="center">買單信息</td>
	<tr>
		<td>帳戶名</td>
		<td><%=S_O.getAccount() %></td>
	<tr>
		<td>股票名稱</td>
		<td><%=S_O.getCompany() %></td>
	<tr>
		<td>股票代號</td>
		<td><%=S_O.getCode() %></td>
	<tr>
		<td>股票現價</td>
		<td><%=S_O.getPrice() %></td>
	<tr>
		<td>掛單價</td>
		<td><%=S_O.getLimit_price() %></td>
	<tr>
		<td>掛單手數</td>
		<td><%=S_O.getQuantity() %></td>
	<tr>
		<td><input type="submit" value="買單送出"></td></br>
		<td><input type ="button" onclick="history.back()" value="回到上一頁"></input></td>
	
</table>
</body>
</html>