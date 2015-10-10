package com.xh.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class TestRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestRegister() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		// 通过枚举类型获取请求文件的头部信息集
		Enumeration<String> headerNames = request.getHeaderNames();

		// 遍历头部信息集
		while (headerNames.hasMoreElements()) {
			// 取出信息名
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			// out.print("键name:" + name + "值value:" + value + "<br/>");
		}

		String name = request.getParameter("user");
		String password = request.getParameter("password");

		if (name == null || name.equals("")) {
			out.print("账号不可为空");
			return;
		}

		if (password == null || password.equals("")) {
			out.print("密码不可为空");
			return;
		}

		out.print("账号name：" + name + "密码password：" + password);
		System.out.println("name：" + name);
		System.out.println("password：" + password);

		// out.print("name" + new String(name.getBytes("iso-8859-1"), "utf-8")
		// + "password"
		// + new String(password.getBytes("iso-8859-1"), "utf-8"));
		System.out.println("name"
				+ new String(name.getBytes("iso-8859-1"), "utf-8"));
		System.out.println("password"
				+ new String(password.getBytes("iso-8859-1"), "utf-8"));

		out.flush();
		out.close();
	}
}
