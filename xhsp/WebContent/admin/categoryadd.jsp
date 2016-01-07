<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, java.sql.*, com.xh.shopping.dao.CategoryDAO,com.xh.shopping.model.Category"%>
<%
	request.setCharacterEncoding("utf-8");

	String strPid = request.getParameter("pid");
	int pid = 0;
	if (strPid != null && !"".equals(strPid.trim())) {
		pid = Integer.parseInt(strPid);
	}

	String action = request.getParameter("action");
	if (action != null && action.trim().equals("add")) {
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		int orderby = Integer.valueOf(request.getParameter("orderby")
				.trim());
		if ((name != null && !"".equals(name))
				|| (descr != null && !"".equals(descr))) {
			if (pid != 0) {
				//	Category.addChild(name, descr, orderby, pid);//添加子类别
				Category parent = Category.loadById(pid);
				Category child=new Category();
				child.setId(-1);
				child.setName(name);
				child.setDescr(descr);
				child.setOrderby(orderby);
				parent.addChild(child);
			} else {
				Category.addTop(name, descr, orderby);//添加根类别
			}
			out.println("恭喜你，添加分类成功！");
		} else {
			out.println("非法操作，类别名称为空！");
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
	<form action="categoryadd.jsp" method="post">
		<input type="hidden" name="action" value="add"> <input
			type="hidden" name="pid" value="<%=pid%>">
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
