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
<table width="400" align="center">
	<tr>
		<td colspan="2" align="center">芥虫(本虫い)</td>
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
		<td>禦┪芥</td>
		<td><%=S_O.getAction() %></td>
	<tr>
		<td>布瞷基</td>
		<td><%=S_O.getPrice() %></td>
	<tr>
		<td>本虫基</td>
		<td><%=S_O.getLimit_price() %></td>
	<tr>
		<td>本虫も计</td>
		<td><%=S_O.getQuantity() %></td>
</body>
</html>