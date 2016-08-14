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
	for (int i = 0; i < childs.size(); i++) {
		Category category = childs.get(i);
		buffer.append(category.getId() + "," + category.getName() + "-");
	}
	if (!StringUtil.isEmpty(buffer.toString())) {
		buffer.deleteCharAt(buffer.length() - 1);
	}
	System.out.println("|" + buffer.toString() + "|");

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-store");//HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	response.getWriter().write(buffer.toString().trim());
%>