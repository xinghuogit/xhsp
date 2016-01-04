package com.xh.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.shopping.jdbc.ExistUtil;
import com.xh.shopping.model.User;
import com.xh.shopping.util.JSONUtil;
import com.xh.shopping.util.MD5;
import com.xh.shopping.util.StringUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONUtil.getInstance().getJSON0002("非法操作,请使用POST请求"));
		System.out.println("非法操作,请使用POST请求");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtil.isStringDataNull(username)) {
			out.print(JSONUtil.getInstance().getJSON("0009", "非法操作", null));
			System.out.println("非法操作：账号为空");
			return;
		}
		if (StringUtil.isStringDataNull(password)) {
			out.print(JSONUtil.getInstance().getJSON("0009", "非法操作", null));
			System.out.println("非法操作：密码为空");
			return;
		}

		MD5 md5 = new MD5(password);

		try {
			User user = ExistUtil.getUser(username);
			if (user != null) {
				if (md5.compute().equals(user.getPassword())) {
					out.print(JSONUtil.getInstance().getJSON0001(user));
					System.out.println("登录成功");
				} else {
					out.print(JSONUtil.getInstance().getJSON0002(
							"密码错误，请重写密码或修改密码"));
					System.out.println("密码错误，请重写密码或修改密码");
					return;
				}
			} else {
				out.print(JSONUtil.getInstance().getJSON0002("账号没有注册，请注册后登陆"));
				System.out.println("1.账号没有注册，请注册后登陆;/n/r2.有可能数据库异常");
				return;
			}
		} catch (Exception e) {
			out.print(JSONUtil.getInstance().getJSON0009("数据库异常，请稍后再试"));
			System.out.println("数据库异常，请稍后再试");
		}

		// try {
		// if (!ExistUtil.isUser(username)) {
		// out.print(JSONUtil.getInstance().getJSON("0002",
		// "账号没有注册，请注册后登陆", null));
		// System.out.println("账号没有注册，请注册后登陆");
		// return;
		// }
		//
		// if (!ExistUtil.isPassword(username, password)) {
		// out.print(JSONUtil.getInstance().getJSON("0002",
		// "密码错误，请重新填写，或者修改密码", null));
		// System.out.println("密码错误，请重新填写，或者修改密码");
		// return;
		// }
		//
		// out.print(JSONUtil.getInstance().getJSON("0002",
		// "密码错误，请重新填写，或者修改密码", null));
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

	}

}
