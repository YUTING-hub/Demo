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
		<td colspan="2" align="center">���(���椤)</td>
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
		<td>�R�ν�</td>
		<td><%=S_O.getAction() %></td>
	<tr>
		<td>�Ѳ��{��</td>
		<td><%=S_O.getPrice() %></td>
	<tr>
		<td>�����</td>
		<td><%=S_O.getLimit_price() %></td>
	<tr>
		<td>������</td>
		<td><%=S_O.getQuantity() %></td>
</body>
</html>