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
<title>订单</title>
</head>
<body>

</body>
</html>