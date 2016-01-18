<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*,com.xh.shopping.dao.CategoryDAO,com.xh.shopping.model.Category"%>

<%
	List<Category> categories = Category.getCategories();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表列表</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Descr</td>
			<td>OrderBy</td>
			<td>PId</td>
			<td>IsLeaf</td>
			<td>Grade</td>
		</tr>

		<%
			for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
				Category category = it.next();
				String preStr = "";
				for (int i = 1; i < category.getGrads(); i++) {
					preStr += "--";
				}
		%>
		<tr>
			<td><%=category.getId()%></td>
			<td><%=preStr + category.getName()%></td>
			<td></td>
			<td><%=category.getOrderby()%></td>
			<td><%=category.getPid()%></td>
			<td><%=category.isLeaf()%></td>
			<td><%=category.getGrads()%></td>
			<td><a href="categoryadd.jsp?pid=<%=category.getId()%>">添加子类别</a>
			</td>
			<td><a href="categoryadd.jsp?id=<%=category.getId()%>">删除该类别</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>