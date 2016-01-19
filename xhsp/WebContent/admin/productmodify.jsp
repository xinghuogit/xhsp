<%@page import="com.xh.shopping.manage.ProductMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, java.sql.*, com.xh.shopping.manage.ProductMgr, com.xh.shopping.model.Product"%>
<%
	request.setCharacterEncoding("utf-8");

	String strId = request.getParameter("id");
	Product p = null;
	if (strId != null && !"".equals(strId)) {
		int id = Integer.parseInt(strId);
		p = ProductMgr.getInstance().loadById(id);
	}

	String action = request.getParameter("action");
	if (action != null && action.trim().equals("add")) {
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		double normalPrice = Double.parseDouble(request
				.getParameter("normalPrice"));
		double memberPrice = Double.parseDouble(request
				.getParameter("memberPrice"));
		int categoryId = Integer.parseInt(request
				.getParameter("categoryId"));

		
		p.setId(-1);
		p.setName(name);
		p.setDescr(descr);
		p.setNormalPrice(normalPrice);
		p.setMemberPrice(memberPrice);
		p.setPdate(new Timestamp(System.currentTimeMillis()));
		p.setCategoryId(categoryId);

		ProductMgr.getInstance().addProduct(p);

		out.println("添加商品成功");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改产品</title>
<script type="text/javascript">
	var arrLeaf = new Array();
	<!--
	function checkDate() {
		if (arrLeaf[document.form.categoryId.selectedIndex] != "leaf") {
			alert("不能选择非叶子节点");
			document.form.categoryId.focus();
			return false;
		}
		return true;
	}
	-->
</script>
</head>
<body>
	<form action="productadd.jsp" method="post"
		onsubmit="return checkdate()" name="form">
		<input type="hidden" name="action" value="add">
		<table>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>类别描述：</td>
				<td><textarea name="descr" rows="8" cols="40"></textarea></td>
			</tr>

			<tr>
				<td>市场价：</td>
				<td><input type="text" name="normalPrice"></td>
			</tr>
			<tr>
				<td>会员价：</td>
				<td><input type="text" name=memberPrice></td>
			</tr>
			<tr>
				<td>类别ID：</td>
				<td><input type="text" name=categoryId></td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
