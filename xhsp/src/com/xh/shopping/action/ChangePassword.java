package com.xh.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.shopping.util.HeaderAuthUtil;
import com.xh.shopping.util.JSONUtil;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		System.out.println("验证username:" + username + "验证\npassword:"
				+ password);

		// String

		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
	}

}
