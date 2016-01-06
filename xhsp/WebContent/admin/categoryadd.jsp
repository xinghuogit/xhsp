<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*, com.xh.shopping.dao.CategoryDAO,com.xh.shopping.model.Category"%>
<%
	request.setCharacterEncoding("utf-8");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("add")) {
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		int orderby = Integer.valueOf(request.getParameter("orderby")
				.trim());
		if ((name != null && !"".equals(name))
				|| (descr != null && !"".equals(descr))) {
			Category.addTop(name, descr, orderby);
			out.println("恭喜你，添加分类成功！");
		} else {
			return;
		}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加类别</title>
</head>
<body>
	<form action="categoryadd.jsp" method="post"> <input
		type="hidden" name="action" value="add">
	<table>
		<tr>
			<td>类别名称：</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>类别排序：</td>
			<td><input type="text" name=orderby></td>
		</tr>
		<tr>
			<td>类别描述：</td>
			<td><textarea name="descr" rows="8" cols="40"></textarea></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" value="提交"></td>
		</tr>
	</table>
	</form>
</body>
</html>
