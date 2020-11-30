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
<td>您好:<%=M.getName() %>
<table width="400" border="1" align="center">
	<tr>
		<td rowspan="3" align="center">主頁
		<td><a href="account_Info.jsp">帳戶信息</a></br>
	</tr>
		<td><a href="stock_search.jsp">股票搜尋</a></br>
	<tr>
		<td><a href=stock_order.jsp">交易清單</a></br>

</table>
</body>
</html>