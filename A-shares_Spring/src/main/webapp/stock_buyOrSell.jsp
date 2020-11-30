<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="java.util.*"
    import="Model.Share"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<%
Share S = (Share)session.getAttribute("S");
%>
<body>
<table width="80%" align="center">
	<tr>
		<td><font size="2">代號</font></td>
		<td><font size="2">名稱</td>
		<td><font size="2">現價</td>
		<td><font size="2">限價</td>
		<td><font size="2">數量</td>
		<td><font size="2">下單</td>
	<tr>
		<form action="stock_buyOrSell" method="post">
		<td><font size="2"><%=S.getCode() %></td>
		<td><font size="2"><%=S.getCompany() %></td>		
		<td name="price"><font size="2"><%=S.getPrice() %></td>
		<td><input type="text" name="limit_price" maxlength="6" style="width:20px;height:14px">
		<td><input type="text" name="quantity" maxlength="6" style="width:20px;height:14px">
		<td>
		<select name="action">
			<option value="0">買
			<option value="1">賣
		</select>
		</td>
		<td><input type="submit" value="ok"></td>
		</form>
</table>
</body>
</html>