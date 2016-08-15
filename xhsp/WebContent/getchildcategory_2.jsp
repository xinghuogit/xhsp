<%@page import="com.xh.shopping.util.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String strId = request.getParameter("id");
	if (StringUtil.isEmpty(strId)) {
		return;
	}
	System.out.println("strId:" + strId);
	int id = Integer.parseInt(strId);
	Category parent = Category.loadById(id);
	List<Category> childs = parent.getChilds(id);
	StringBuffer buffer = new StringBuffer();

	/* 	
		//普通的字符串
	 	for (int i = 0; i < childs.size(); i++) {
	 Category category = childs.get(i);
	 buffer.append(category.getId() + "," + category.getName() + "-");
	 }
	 if (!StringUtil.isEmpty(buffer.toString())) {
	 buffer.deleteCharAt(buffer.length() - 1);
	 } */

	for (int i = 0; i < childs.size(); i++) {
		Category category = childs.get(i);
		buffer.append("document.form2.category2.options[" + (i + 1)
				+ "].text = '" + category.getName() + "';\n");
		buffer.append("document.form2.category2.options[" + (i + 1)
				+ "].value = '" + category.getId() + "';\n");
	}
	buffer.insert(0,
			"document.form2.category2.options[0].text = '请选择二级目录';\n");
	buffer.insert(0,
			"document.form2.category2.options[0].value = '-1';\n");
	buffer.insert(0, "document.form2.category2.selectedIndex = 0;\n");
	buffer.insert(0, "document.form2.category2.options.length = "
			+ (childs.size() + 1) + ";\n");

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-store");//HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	response.getWriter().write(buffer.toString().trim());
	System.out.println(buffer.toString());
	//System.out.println("|" + buffer.toString() + "|");
%>