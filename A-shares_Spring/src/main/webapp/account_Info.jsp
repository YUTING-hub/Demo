<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<%
Member M =(Member)session.getAttribute("M");
%>
<body>
<table width="400" align="center">
	<tr>
		<td colspan="2" align="center">�b��H��</td>
	<tr>
		<td>�m�W</td>
		<td><%=M.getName() %></td>
	<tr>
		<td>�b��W</td>
		<td><%=M.getAccount() %></td>
	<tr>
		<td>�b����B</td>
		<td><%=M.getAssets() %></td>	
</table>
</body>
</html>