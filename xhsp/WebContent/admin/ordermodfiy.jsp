<%@page import="com.xh.shopping.model.SalesItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.xh.shopping.manage.OrderMgr"%>
<%@page import="com.xh.shopping.model.SalesOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%@ include file="_sessioncheck.jsp"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	SalesOrder so = OrderMgr.getInstance().loadById(id);
%>

<center>
	下单人：<%=so.getUser().getUsername()%>
	<form action="form" action="ordermodfiy.jsp" method="post">
		<select name="states">
			<option value="1">已处理</option>
			<option value="0">未处理</option>
			<option value="3">废单</option>
		</select> <br> <input type="submit" value="提交">
	</form>
</center>
<script type="text/javascript">
	for (i=0; i<document.forms("form").status.options.length; i++) {
		if(document.forms("form").status.options[i].value == <%=so.getState()%>
	) {
			document.forms("form").status.selectedIndex = i;
		}
	}
</script>

