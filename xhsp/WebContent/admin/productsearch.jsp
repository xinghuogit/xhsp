<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*,com.xh.shopping.manage.ProductMgr,com.xh.shopping.model.Product"%>
<%!private static final int PAGE_SIZE = 3;%>
<%
	String strpageno = request.getParameter("pageno");
	int pageno = 1;
	if (strpageno != null) {
		pageno = Integer.parseInt(strpageno);
	}
	if (pageno < 1) {
		pageno = 1;
	}
%>
<%
	List<Product> products = new ArrayList<Product>();
	int pageCount = ProductMgr.getInstance().getProducts(products,
			pageno, PAGE_SIZE);
	if (pageno > pageCount) {
		pageno = pageCount;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索商品</title>
</head>
<body> 
	<center>简单搜索</center>
	<form action="productsearch.jsp" method="post">
		<input type="hidden" name="action" value="simplexsearch"> 类别：<select></select>
		关键字：<input type="text" name="name"> <input type="submit"
			value="点击搜索">
	</form>

	<center>复杂搜索</center>
	<form action="productsearch.jsp" method="post">
		<input type="hidden" name="action" value="complexsearch">

	</form>
</body>
</html>