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
<form action="return_home" method="post">
<table width="80%" align="center">
	<tr>
		<td><font size="2">�N��</font></td>
		<td><font size="2">�W��</td>
		<td><font size="2">�{��</td>
		<td><font size="2">�����</td>
		<td><font size="2">�ƶq</td>
		<td><font size="2">����ɶ�</td>
	<tr>
		<td><font size="2"><%=S_O.getCode() %></td>
		<td><font size="2"><%=S_O.getCompany() %></td>
		<td><font size="2"><%=S_O.getPrice() %></td>
		<td><font size="2"><%=S_O.getAverage_price() %></td>
		<td><font size="2"><%=S_O.getQuantity() %></td>
		<td><font size="2"><%=S_O.getDatetime() %></td>	
	<tr>
		<td><input type="submit" value="�^����"></td></br>	
</body>
</html>