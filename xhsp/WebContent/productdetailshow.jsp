<%@page import="com.xh.shopping.model.Category"%>
<%@page import="com.xh.shopping.manage.ProductMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, java.sql.*, com.xh.shopping.manage.ProductMgr, com.xh.shopping.model.Product"%>

<%
	request.setCharacterEncoding("utf-8");
	String strId = request.getParameter("id");
	int id = -1;
	Product p = null;

	if (strId != null && !"".equals(strId)) {
		id = Integer.parseInt(strId);
		p = ProductMgr.getInstance().loadById(id);
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<img alt="<%=p.getName()%>" src="./image/store_logo.png_c292x292"
		width="90" border="0">
	<br>
	商品名：<%=p.getName()%><br>
	<br>
	商品简介：<%=p.getDescr()%><br>
	<br>
	市场价：<%=p.getNormalPrice()%>￥<br>
	<br>
	会员价：<%=p.getMemberPrice()%>￥<br>
	<br>
	上架时间：<%=p.getPdate()%><br>
	<br>
	<a href="buy.jsp?id=<%=id%>">一键购买</a>
</body>
</html>
