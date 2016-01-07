<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*, com.xh.shopping.dao.CategoryDAO,com.xh.shopping.model.Category"%>

<%
	List<Category> categories = Category.getCategories();
%>
<html>
<head>
<script language="javascript" src="script/TV20.js"></script>
<title>列表列表</title>
</head>
<body>
	<script language="javascript">
		addNode(-1, 0, "hehe", "images/top.gif");
		addNode(0, 1, "haha", "images/top.gif");
		addNode(0, 2, "haha", "images/top.gif");
		addNode(1, 3, "haha", "images/top.gif");
		addNode(1, 4, "haha", "images/top.gif");
		addNode(2, 5, "haha", "images/top.gif");
		addNode(2, 6, "haha", "images/top.gif");
		showTV();
	</script>
</body>
</html>