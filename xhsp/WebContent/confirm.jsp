<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.model.Cart"%>
<%@page import="com.xh.shopping.manage.CartMgr"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%@page import="java.util.Iterator"%>

<%@include file="_usersessioncheck.jsp"%>
<%
	List<Cart> carts = null;
	carts = CartMgr.getInstance().getCarts(user.getId());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<td>商品id</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
			<td>商品总价</td>
		</tr>
		<%
			if (carts != null && carts.size() > 0) {
				for (Iterator<Cart> it = carts.iterator(); it.hasNext();) {
					Cart cart = it.next();
		%>
		<tr>
			<td><%=cart.getProductid()%></td>
			<td><%=cart.getProductname()%></td>
			<td><%=cart.getMemberprice()%></td>
			<td><%=cart.getProductid()%></td>
			<td><%=cart.getMemberTotalPrice()%></td>
		</tr>
		<%
			}
			} else {
		%>
		<element>没有下单商品</element>
		<%
			}
		%>
	</table>
	<center>
		共<%=CartMgr.getInstance().getTotalPrice(carts)%>
		<br> <br> 欢迎您 <%=user.getName()%> 请确认您的送货信息

		<form action="order.jsp" method="post">
			送货信息:<br>
			<textarea name="addr"><%=user.getAddr()%></textarea><br>
			<input type="submit" value="确认下单">
		</form>
	</center>
</body>
</html>