<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.xh.shopping.model.Product"%>
<%@page import="com.xh.shopping.manage.ProductMgr"%>
<%@page import="com.xh.shopping.model.Cart"%>
<%@page import="com.xh.shopping.manage.CartMgr"%>
<%@ include file="_usersessioncheck.jsp"%>

<%
	request.setCharacterEncoding("utf-8");
	String strId = request.getParameter("id");
	int id = -1;
	Product p = null;
	Cart cart = null;
	CartMgr cartMgr = null;

	if (strId != null && !"".equals(strId)) {
		id = Integer.parseInt(strId);
		p = ProductMgr.getInstance().loadById(id);
		cart = new Cart();
		cart.setProductid(p.getId());
		cart.setProductname(p.getName());
		cart.setNormalprice(p.getNormalPrice());
		cart.setMemberprice(p.getMemberPrice());
		cart.setCount(1);
		//cart.setUserid(user.getId());
		//cartMgr.addCart(cart);
	}
	out.println("user:"+user == null);
%>

