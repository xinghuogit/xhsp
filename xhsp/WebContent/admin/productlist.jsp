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
<title>商品列表</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Descr</td>
			<td>NormalPrice</td>
			<td>MemberPrice</td>
			<td>PDate</td>
			<td>CategoryId</td>
		</tr>

		<%
			for (Iterator<Product> it = products.iterator(); it.hasNext();) {
				Product product = it.next();
		%>
		<tr>
			<td><%=product.getId()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getDescr()%></td>
			<td><%=product.getNormalPrice()%></td>
			<td><%=product.getMemberPrice()%></td>
			<td><%=product.getPdate()%></td>
			<td><%=product.getCategoryId()%></td>
			<td><a href="categoryadd.jsp?pid=<%=product.getId()%>">修改商品</a>
			</td>
			<td><a href="categoryadd.jsp?id=<%=product.getId()%>">删除商品</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<center>
		第<%=pageno%>页 &nbsp; 共<%=pageCount%>页 &nbsp; <a
			href="productlist.jsp?pageno=1">首页</a>&nbsp; <a
			href="productlist.jsp?pageno=<%=pageno - 1%>">上一页</a> &nbsp; <a
			href="productlist.jsp?pageno=<%=pageno + 1%>">下一页</a> &nbsp; <a
			href="productlist.jsp?pageno=<%=pageCount%>">最后一页</a>
	</center>

</body>
</html>