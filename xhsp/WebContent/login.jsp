<%@page import="com.xh.shopping.model.User"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%@page import="com.xh.shopping.manage.UserMgr"%>
<%@page import="com.xh.shopping.dao.UserDAOMySQL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String action = request.getParameter("action");
	User user = null;
	if (action != null && action.equals("login")) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtil.isEmpty(username)) {
			out.println("账号不可为空");
		} else if (StringUtil.isEmpty(password)) {
			out.println("密码不可为空");
		} else {
			user = UserMgr.getInstance().loadByUserNmaePassword(
					username, password);
		}
	}
	if (user == null) {
		out.println("账号或者密码错误请重新输入");
	} else {
		session.setAttribute("user", user);
		response.sendRedirect("homegood.jsp");

	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form name="form" action="login.jsp" method="post">
		<input type="hidden" name="action" value="login">
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户登录</td>
			</tr>
			<tr>
				<td>账号：</td>
				<td><input type="text" name="username" size="30" maxlength="10">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" size="30"
					maxlength="10"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="登录"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>