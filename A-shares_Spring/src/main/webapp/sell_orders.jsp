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
		<td colspan="2" align="center">���H��</td>
	<tr>
		<td>�b��W</td>
		<td><%=S_O.getAccount() %></td>
	<tr>
		<td>�Ѳ��W��</td>
		<td><%=S_O.getCompany() %></td>
	<tr>
		<td>�Ѳ��N��</td>
		<td><%=S_O.getCode() %></td>
	<tr>
		<td>�Ѳ��{��</td>
		<td><%=S_O.getPrice() %></td>
	<tr>
		<td>�����</td>
		<td><%=S_O.getLimit_price() %></td>
	<tr>
		<td>������</td>
		<td><%=S_O.getQuantity() %></td>
	<tr>
		<td><input type="submit" value="���e�X"></td></br>
		<td><input type ="button" onclick="history.back()" value="�^��W�@��"></input></td>
		
</body>
</html>