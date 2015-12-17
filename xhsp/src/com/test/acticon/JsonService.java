package com.test.acticon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

		PrintWriter out = response.getWriter();

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

	}

}
