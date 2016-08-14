<%@page import="com.xh.shopping.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xh.shopping.*,java.util.Date"%>
<%
	request.setCharacterEncoding("utf-8");
	String action = request.getParameter("action");
	if (action != null && action.equals("register")) {
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String auth = request.getParameter("auth");
		String nickname = request.getParameter("nickname");
		String addr = request.getParameter("addr");
		Date rdate = new Date(System.currentTimeMillis());
		Date cpdate = new Date(System.currentTimeMillis());

		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setName(nickname);
		user.setAddr(addr);
		user.setRdate(rdate);
		user.setCpdate(cpdate);
		user.setAuth("auth");
		user.save();
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>星火商城会员注册</title>
<script type="text/javascript">
	var req;
	function validate() {
		var idField = document.getElementById("userid");
		var url = "validate.jsp?id=" + escape(idField.value);
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		req.open("GET", url, true);
		req.onreadystatechange = callback2;
		req.send(null);
	}

	function callback2() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var msg = req.responseXML.getElementsByTagName("msg")[0];
				//				alert(msg.childNodes[0].nodeValue);
				setMsg(msg.childNodes[0].nodeValue);
			} else {
				alert("错误");
			}
		}
	}

	function setMsg(msg) {
		mdiv = document.getElementById("usermsg");
		if (msg == "invalid1") {
			mdiv.innerHTML = "<font color='red'>用户已存在</font>"
		} else {
			mdiv.innerHTML = "<font color='green'>检测通过，可以注册</font>"
		}
	}
</script>
</head>
<body>
	<form name="form" action="register.jsp" method="post">
		<input type="hidden" name="action" value="register" />
		<div align="center" style="height: 120px; color: black;">会员注册</div>
		<table style="width: 540; border: 2;" align="center">
			<tr>
				<td>账号：</td>
				<td><input type="text" name="username" id="userid" size="30"
					maxlength="20" onblur="validate()"></td>
				<td><span id="usermsg"></span>
			</tr>

			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" size="30"
					maxlength="20"></td>
			</tr>

			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="password2" size="30"
					maxlength="20"></td>
			</tr>

			<tr>
				<td>手机：</td>
				<td><input type="text" name="phone" size="30" maxlength="20"></td>
			</tr>

			<tr>
				<td>昵称：</td>
				<td><input type="text" name="nickname" size="30" maxlength="20"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="auth" size="30" maxlength="20"></td>
			</tr>

			<tr>
				<td>地址：</td>
				<td><textarea rows="12" cols="30" name="addr"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="提交"></td>
			</tr>

		</table>

	</form>


</body>
</html>