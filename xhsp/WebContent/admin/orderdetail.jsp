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
	List<SalesOrder> sos = (List<SalesOrder>) session
	.getAttribute("sos");
	if (sos == null) {
		out.println("没有任何交易项");
		return;
	}
	int id = 0;
	request.setCharacterEncoding("utf-8");
	String stri = request.getParameter("id");
	if (!StringUtil.isEmpty(stri)) {
		id = Integer.valueOf(stri);
	}
	SalesOrder so = sos.get(id);
	OrderMgr.getInstance().getSalesItem(so);
	List<SalesItem> sis = so.getSalesItems();
	if (sis == null) {
		out.print("无数据");
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function showProductInfo(descr) {
		document.getElementById("productInfo").innerHTML = "<font size=3 color=red>"
				+ descr + "</font>"
	}
</script>


<title>订单明细</title>
</head>
<body>

	<center>
		送货地址：<%=so.getAddr()%><br> 购买用户：<%=so.getUser().getUsername()%><br>
		下单时间：<%=so.getAdate()%><br> 商品总价：<%=OrderMgr.getInstance().getTotalPrice(sis)%><br>
		订单状态：<%=so.getState() == 0 ? "未完成" : "已支付"%><br>

		<table border="1" align="center">
			<tr>
				<td>商品名称</td>
				<td>商品单价</td>
				<td>商品数量</td>
				<td>商品总价</td>
			</tr>

			<%
				for (int i = 0; i < sis.size(); i++) {
					SalesItem si = sis.get(i);
			%>
			<tr>
				<td onmouseover="showProductInfo('<%=si.getProduct().getDescr()%>')"><%=si.getProduct().getName()%></td>
				<td><%=si.getUnitprice()%></td>
				<td><%=si.getPcount()%></td>
				<td><%=si.getTotalPrice()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<div style="border: 5px double purple; width: 400;" id="productInfo">&nbsp;</div>
	</center>
</body>
</html>