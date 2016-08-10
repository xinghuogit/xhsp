<%@page import="com.xh.shopping.manage.OrderMgr"%>
<%@page import="com.xh.shopping.model.SalesOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="_sessioncheck.jsp"%>
<%!private static final int PAGE_SIZE = 3;%>
<%
	String strpageno = request.getParameter("pageno");
	int pageno = 1;
	if (strpageno != null) {
		pageno = Integer.parseInt(strpageno);
	}
	if (pageno < 1) {
		pageno = 1;
	}
%>
<%
	List<SalesOrder> sos = new ArrayList<SalesOrder>();
	int pageCount = OrderMgr.getInstance().getSOS(sos, pageno,
			PAGE_SIZE, true);
	if (pageno > pageCount) {
		pageno = pageCount;
	}
	session.setAttribute("sos", sos);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>信息</td>
			<td>用户</td>
			<td>地址</td>
			<td>时间</td>
			<td>总价</td>
			<td>状态</td>
		</tr>

		<%
			for (int i = 0; i < sos.size(); i++) {
				SalesOrder so = sos.get(i);
		%>
		<tr>
			<td><%=so.getId()%></td>
			<td><%=so.getId()%></td>
			<td><%=so.getUser().getUsername()%></td>
			<td><%=so.getAddr()%></td>
			<td><%=so.getAdate()%></td>
			<td><%=so.getAdate()%></td>
			<td><%=so.getState() == 0 ? "未完成" : "已支付"%></td>
			<td><a href="orderdetail.jsp?id=<%=i%>">订单明细</a></td>
			<td><a href="ordermodfiy.jsp?id=<%=so.getId()%>">订单明细</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<center>
		第<%=pageno%>页 &nbsp; 共<%=pageCount%>页 &nbsp; <a
			href="orderlist.jsp?pageno=1">首页</a>&nbsp; <a
			href="orderlist.jsp?pageno=<%=pageno - 1%>">上一页</a> &nbsp; <a
			href="orderlist.jsp?pageno=<%=pageno + 1%>">下一页</a> &nbsp; <a
			href="orderlist.jsp?pageno=<%=pageCount%>">最后一页</a>
	</center>

</body>
</html>