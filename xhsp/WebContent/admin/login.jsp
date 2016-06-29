<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String action = request.getParameter("action");
	if (action != null && action.equals("login")) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || !username.equals("admin")) {
			out.println("用户名不正确");
		} else if (password == null || !password.equals("admin")) {
			out.println("密码不正确");
		} else {
			session.setAttribute("admin", "true");
			response.sendRedirect("home.jsp");
		}

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