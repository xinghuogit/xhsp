<%@page import="com.xh.shopping.model.Category"%>
<%@page import="com.xh.shopping.manage.ProductMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, java.sql.*, com.xh.shopping.manage.ProductMgr, com.xh.shopping.model.Product"%>

<%
	request.setCharacterEncoding("utf-8");
    String strId=request.getParameter("id");
	int id=-1;
	Product product=null;
	
	if(strId!=null && !"".equals(strId)){
		id=Integer.parseInt(strId);
		product = ProductMgr.getInstance().loadById(id);
	}
			
	
	String action = request.getParameter("action");
	System.out.println("action:"+action);
	if (action != null && action.trim().equals("modify")) {
		
		int pId=Integer.parseInt(request.getParameter("pId"));
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		double normalPrice = Double.parseDouble(request
				.getParameter("normalPrice"));
		double memberPrice = Double.parseDouble(request
				.getParameter("memberPrice"));
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		
		Product p = new Product();
		p.setId(pId);
		p.setName(name);
		p.setDescr(descr);
		p.setNormalPrice(normalPrice);
		p.setMemberPrice(memberPrice);
		p.setPdate(new Timestamp(System.currentTimeMillis()));
		p.setCategoryId(categoryId);

		boolean isUpdate=ProductMgr.getInstance().updateProduct(p);
		System.out.println("isUpdate:"+isUpdate);
		if(isUpdate){
			out.println("修改商品成功");
		}
		%>
		<<script type="text/javascript">
			<!--
			window.parent.main.location.reload();	
			//-->
		</script>
		<% 
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
<script type="text/javascript">
	var arrLeaf =new Array();
	<!--
	function checkdate() {
		if(arrLeaf[document.form.categoryId.selectedIndex] != "leaf"){
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
	<form action="productmodify.jsp" method="post" onsubmit="return checkdate()" name="form">
		<input type="hidden" name="action" value="modify">
		<input type="hidden" name="pId" value="<%=id%>">
		<table>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name" value="<%=product.getName()%>"></td>
			</tr>
			<tr>
				<td>类别描述：</td>
				<td><textarea name="descr" rows="8" cols="40"><%=product.getDescr() %></textarea></td>
			</tr>

			<tr>
				<td>市场价：</td>
				<td><input type="text" name="normalPrice" value="<%=product.getNormalPrice()%>"></td>
			</tr>
			<tr>
				<td>会员价：</td>
				<td><input type="text" name=memberPrice value="<%=product.getMemberPrice()%>"></td>
			</tr>
			<tr>
				<td>商品类别：</td>
				<td><select name="categoryId">
						<option value="0">所有类别</option>
						<script type="text/javascript">
							arrLeaf[0] = "notleaf";						
						</script>
						<%	
							List<Category> categories=Category.getCategories();
							int index = 1;
							for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
								Category c = it.next();
								String preStr = "--";
								for (int i = 1; i < c.getGrads(); i++) {
									preStr += "--";
								}
						%>
						<script type="text/javascript">
							arrLeaf[<%=index%>] = '<%=c.isLeaf() ? "leaf" : "notleaf"%>';
						</script>
						<option value="<%=c.getId()%>" <%=c.getId() == product.getCategory().getId() ? "selected" : "" %>><%=preStr + c.getName()%></option>
						<%
							index ++;
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
