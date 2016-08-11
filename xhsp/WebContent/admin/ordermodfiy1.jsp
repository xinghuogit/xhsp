<%@page import="com.xh.shopping.model.SalesItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.xh.shopping.manage.OrderMgr"%>
<%@page import="com.xh.shopping.model.SalesOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%
	SalesOrder so = new SalesOrder();
	so.setState(2);
%>

<center>
	下单人：<%=so.getState()%>
	<form name="form" action="ordermodfiy.jsp" method="post">
		<select name="status">
			<option value="1">已处理</option>
			<option value="2">废单</option>
			<option value="0">未处理</option>
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

