<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.model.Cart"%>
<%@page import="com.xh.shopping.manage.CartMgr"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%@page import="java.util.Iterator"%>
<%@ include file="_usersessioncheck.jsp"%>
<%
	String strId = request.getParameter("userid");
	int id = -1;
	List<Cart> carts = null;

	if (!StringUtil.isEmpty(strId)) {
		id = Integer.parseInt(strId);
		carts = CartMgr.getInstance().getCarts(id);
	}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
	<form action="cartupdate.jsp" method="get">
		<input type="hidden" name="userid" value=<%=id%>>
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
				<td><input type="text" size="4"
					name=<%=cart.getProductid() + ""%> value=<%=cart.getCount()%>></td>
				<td><%=cart.getMemberTotalPrice()%></td>
			</tr>
			<%
				}
				} else {
			%>
			<element>购物车没有更多商品</element>
			<%
				}
			%>
		</table>
		<center>
			<input type="submit" value="修改数量"> <input type="button"
				value="确认订单" onclick="document.location.href='confirm.jsp'">
		</center>
	</form>
</body>
</html>