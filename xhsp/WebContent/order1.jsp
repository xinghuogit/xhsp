<%@page import="com.xh.shopping.manage.CartMgr"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.xh.shopping.model.SalesOrder"%>
<%@page import="com.xh.shopping.manage.OrderMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="com.xh.shopping.model.Cart"%>
<%@page import="com.xh.shopping.util.StringUtil"%>

<%@include file="_usersessioncheck.jsp"%>

<%
	List<Cart> carts = (List<Cart>) session.getAttribute("carts");
	if (carts == null) {
		out.println("没有任何购物车项");
		return;
	}
%>
<%
	request.setCharacterEncoding("utf-8");
	String addr = request.getParameter("addr");
	if (StringUtil.isEmpty(addr)) {
		addr = user.getAddr();
	}
	SalesOrder so = new SalesOrder();
	so.setUser(user);
	so.setAddr(addr);
	so.setAdate(new Timestamp(System.currentTimeMillis()));
	so.setCarts(carts);
	so.setState(1);
	boolean state = OrderMgr.getInstance().addOrder(so);
	if (state) {
		// CartMgr.getInstance().deleteCarts(carts); 
	}
	session.removeAttribute("carts");
%>
<center>欢迎您在本站购物！欢迎继续！</center>