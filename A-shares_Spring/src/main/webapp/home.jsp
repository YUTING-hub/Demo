<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.Member"
    import="Model.FactoryModel"%>
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
<td>�z�n:<%=M.getName() %>
<table width="400" border="1" align="center">
	<tr>
		<td rowspan="3" align="center">�D��
		<td><a href="account_Info.jsp">�b��H��</a></br>
	</tr>
		<td><a href="stock_search.jsp">�Ѳ��j�M</a></br>
	<tr>
		<td><a href=stock_order.jsp">����M��</a></br>

</table>
</body>
</html>