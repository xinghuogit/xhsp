package com.test.acticon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.Person;
import com.test.model.Result;
import com.test.model.School;
import com.xh.shopping.model.User;
import com.xh.shopping.util.JSONUtil;

/**
 * Servlet implementation class Json
 */
@WebServlet("/Json")
public class JsonService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JsonService() {
		super();
		// TODO Auto-generated constructor stub
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
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

//		PrintWriter out = response.getWriter();

		Result result = new Result();
		result.setResult(1);
		List<Person> persons = new ArrayList<Person>();
		result.setPersons(persons);

		Person person1 = new Person();
		person1.setName("张三");
		person1.setAge(14);
		person1.setUrl("http://e.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=b3f83a5681d6277fe9473a3e18083308/7c1ed21b0ef41bd59997461957da81cb38db3d12.jpg");

		Person person2 = new Person();
		person2.setName("李四");
		person2.setAge(13);
		person2.setUrl("http://e.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=b3f83a5681d6277fe9473a3e18083308/7c1ed21b0ef41bd59997461957da81cb38db3d12.jpg");

		List<School> schools = new ArrayList<School>();

		School school1 = new School();
		school1.setName("苍大");

		School school2 = new School();
		school2.setName("藤大");

		schools.add(school1);
		schools.add(school2);

		person2.setSchools(schools);
		persons.add(person2);

		Gson gson = new Gson();

		System.out.println(gson.toJson(result));

		List<User> users = new ArrayList<User>();
		User user = new User();

		try {
			users = user.getUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (users.size() > 0) {
			String json = JSONUtil.getInstance().getJSON("0000", "成功", users);
			System.out.println("json:" + json);
			String json1 = JSONUtil.getInstance().getJSON("0000", "成功", null);
			System.out.println("json1:" + json1);

			User user2 = new User();
			user2.setId(0);
			user2.setUsername("18380287539");
			user2.setPassword("18380287539");
			user2.setPhone("18380287539");
			user2.setName("18380287539");
			// user2.setAddr(addr);
			user2.setRdate(new Date());
			user2.setCpdate(new Date());
			// user2.setAuth(auth);

			String json2 = JSONUtil.getInstance().getJSON("0000", "成功", user2);
			System.out.println("json2:" + json2);
		}
	}

}
