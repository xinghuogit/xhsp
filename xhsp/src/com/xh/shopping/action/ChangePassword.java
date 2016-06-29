package com.xh.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.shopping.jdbc.ExistUtil;
import com.xh.shopping.jdbc.SQLSTATEMENT;
import com.xh.shopping.model.User;
import com.xh.shopping.util.HeaderAuthUtil;
import com.xh.shopping.util.JSONUtil;
import com.xh.shopping.util.MD5;
import com.xh.shopping.util.StringUtil;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;

	public ChangePassword() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONUtil.getInstance().getJSON0002("非法操作,请使用POST请求"));
		System.out.println("非法操作,请使用POST请求");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String authorization;
		String value = null;
		String[] namepwd;
		String headerAuth;

		// 验证头部
		Enumeration<String> headerNames = request.getHeaderNames();
		// 遍历头部信息集
		while (headerNames.hasMoreElements()) {
			authorization = (String) headerNames.nextElement();
			if ("authorization".equals(authorization)) {
				value = request.getHeader(authorization);
				System.out.println("value:" + value);
			}
			continue;
		}

		headerAuth = HeaderAuthUtil.getHeaderAuth(value);

		if (headerAuth.equals("ok")) {
			System.out.println("头部验证信息不为空");
		} else {
			out.print(JSONUtil.getInstance().getJSON0002("非法操作：头部信息不正确"));
			System.out.println("非法操作：头部信息不正确");
			return;
		}

		namepwd = value.split(":");

		String username = namepwd[0];
		String password = namepwd[1];

		System.out.println("验证username:" + username + "\n验证password:"
				+ password);

		try {
			user = ExistUtil.getUser(username);
			if (user != null) {
				if (password.equals(user.getPassword())) {
					// out.print(JSONUtil.getInstance().getJSON0001(user));
					System.out.println("Auth账号密码验证通过");
				} else {
					out.print(JSONUtil.getInstance().getJSON0002(
							"非法操作：Auth密码错误"));
					System.out.println("非法操作：Auth密码错误");
					return;
				}
			} else {
				out.print(JSONUtil.getInstance().getJSON0002(
						"非法操作：Auth账号密码寻找不到账号"));
				System.out.println("1.非法操作：Auth账号密码寻找不到账号;/n/r2.有可能数据库异常");
				return;
			}
		} catch (Exception e) {
			out.print(JSONUtil.getInstance().getJSON0009("数据库异常，请稍后再试"));
			System.out.println("数据库异常，请稍后再试");
		}

		// 验证原密码 新密码确认密码
		String passwor = request.getParameter("password").trim();
		String passwor1 = request.getParameter("password1").trim();
		String passwor2 = request.getParameter("password2").trim();

		if (StringUtil.isEmpty(passwor)
				|| StringUtil.isEmpty(passwor1)
				|| StringUtil.isEmpty(passwor2)) {
			out.print(JSONUtil.getInstance().getJSON0002("非法操作：原密码、新密码、确认密码为空"));
			System.out.println("非法操作：原密码、新密码、确认密码为空");
			return;
		}

		MD5 md5 = new MD5(passwor);
		if (md5.compute().equals(user.getPassword())) {
			System.out.println("原密码验证通过");
		} else {
			out.print(JSONUtil.getInstance().getJSON0002("原密码错误，请重填密码"));
			System.out.println("原密码验证错误");
			return;
		}

		if (!passwor1.equals(passwor2)) {
			out.print(JSONUtil.getInstance().getJSON0002("非法操作：新密码、确认密码不同"));
			System.out.println("非法操作：新密码、确认密码不同");
			return;
		} else {
			try {
				SQLSTATEMENT.changePassword(user.getId(), username, new MD5(
						passwor1).compute());
				// String content = "修改密码成功";
				user = ExistUtil.getUser(username);
				out.print(JSONUtil.getInstance().getJSON0001(user));
				System.out.println("修改密码成功,返回用户新信息");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print(JSONUtil.getInstance().getJSON0009("数据库异常，请稍后再试"));
				System.out.println("数据库异常，请稍后再试");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
