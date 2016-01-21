<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page import="com.xh.shopping.dao.CategoryDAO"%>
<%@page import="com.xh.shopping.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*,com.xh.shopping.manage.ProductMgr,com.xh.shopping.model.Product"%>
<%!private static final int PAGE_SIZE = 3;%>
<%
	List<Category> categories = Category.getCategories();
	List<Product> products= null;
	int pageNo=1;
	int pageCount=0;
	String strCategoryId=null;
	String keyword=null;
	double lowNormalPrice=-1;
	double highNormalPrice=-1;
	double lowMemberPrice=-1;
	double highMemberPrice=-1;
	String strStartDate=null;
	String strEndDate=null;
%>
<%
	request.setCharacterEncoding("utf-8");

	String action = request.getParameter("action");
	//复杂搜索
	if (action != null && action.trim().equals("complexsearch")) {
		String strPageNo = request.getParameter("pageNo");
		
		if(strPageNo!=null && !"".equals(strPageNo)&&!"0".equals(strPageNo) ){
			pageNo = Integer.parseInt(strPageNo);
		}
		
		strCategoryId = request.getParameter("categoryId");
		int[] idArray;
		if(strCategoryId == null && "".equals(strCategoryId.trim())){
			idArray=null;
		}else{
			String[] strCategoryIds = request.getParameterValues("categoryId");
			idArray = new int[strCategoryIds.length];
			for(int i = 0; i<strCategoryIds.length; i++){
				idArray[i] = Integer.parseInt(strCategoryIds[i]);
			}
		}
		System.out.println("request.getMethod()"+request.getMethod());
		
		if(request.getMethod().equals("GET")){
			keyword = new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"utf-8");
		}else if(request.getMethod().equals("POST")){
			keyword= request.getParameter("keyword");
		}
		
	
		lowNormalPrice = Double.parseDouble(request
		.getParameter("lowNormalPrice"));
		highNormalPrice = Double.parseDouble(request
		.getParameter("highNormalPrice"));
		lowMemberPrice = Double.parseDouble(request
		.getParameter("lowMemberPrice"));
		highMemberPrice = Double.parseDouble(request
		.getParameter("highMemberPrice"));
		
		Timestamp startDate;
		strStartDate=request.getParameter("startDate");
		if(strStartDate==null || "".equals(strStartDate.trim())){
			startDate = null;
		}else{
	 		startDate = Timestamp.valueOf(request.getParameter("startDate"));
		}
		
		Timestamp endDate;
		strEndDate=request.getParameter("endDate");
		if(strEndDate==null || "".equals(strEndDate.trim())){
			endDate = null;
		}else{
			endDate = Timestamp.valueOf(request.getParameter("endDate"));
		}

	
		products=new ArrayList<Product>();
		pageCount=ProductMgr.getInstance().searchProducts(products,idArray, keyword,
		lowNormalPrice, highNormalPrice, lowMemberPrice,
		highMemberPrice, startDate, endDate, pageNo, PAGE_SIZE);
		/**	
		int pageCount=0;
		List<Product> products=ProductMgr.getInstance().searchProducts(idArray, keyword,
		lowNormalPrice, highNormalPrice, lowMemberPrice,
		highMemberPrice, startDate, endDate, pageNo, PAGE_SIZE);*/
		out.println("搜索商品成功"+products.size());
%>
<%
	}
%>


<%	
	//处理简单搜索2
	if (action != null && action.trim().equals("simplexsearch2")) {
		String strPageNo = request.getParameter("pageNo");
		
		if(strPageNo!=null && !"".equals(strPageNo)&&!"0".equals(strPageNo) ){
			pageNo = Integer.parseInt(strPageNo);
		}
		
		strCategoryId = request.getParameter("categoryId");
		int[] idArray;
		if(strCategoryId == null && "".equals(strCategoryId.trim())){
			idArray=null;
		}else{
			String[] strCategoryIds = request.getParameterValues("categoryId");
			idArray = new int[strCategoryIds.length];
			for(int i = 0; i<strCategoryIds.length; i++){
				idArray[i] = Integer.parseInt(strCategoryIds[i]);
			}
		}
		
		if(request.getMethod().equals("GET")){
			keyword = new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"utf-8");
		}else if(request.getMethod().equals("POST")){
			keyword= request.getParameter("keyword");
		}
	
		products=new ArrayList<Product>();
		pageCount=ProductMgr.getInstance().searchProducts(products,idArray, keyword, 
															  -1, -1, -1, -1, 
															  null, null, pageNo, PAGE_SIZE);
		/**	
		int pageCount=0;
		List<Product> products=ProductMgr.getInstance().searchProducts(idArray, keyword,
		lowNormalPrice, highNormalPrice, lowMemberPrice,
		highMemberPrice, startDate, endDate, pageNo, PAGE_SIZE);*/
		out.println("搜索商品成功"+products.size());
%>
<%
	}
%>

<!--搜索成功后结果-->
<%
if(products!=null && products.size()>0 ){%>
<center>搜索结果</center>
<table border="1" align="center">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>Descr</td>
		<td>NormalPrice</td>
		<td>MemberPrice</td>
		<td>PDate</td>
		<td>CategoryId</td>
	</tr>

	<%
		for (Iterator<Product> it = products.iterator(); it.hasNext();) {
			Product product = it.next();
	%>
	<tr>
		<td><%=product.getId()%></td>
		<td><%=product.getName()%></td>
		<td><%=product.getDescr()%></td>
		<td><%=product.getNormalPrice()%></td>
		<td><%=product.getMemberPrice()%></td>
		<td><%=product.getPdate()%></td>
		<td><%=product.getCategoryId()%></td>
		<td><a href="categoryadd.jsp?pid=<%=product.getId()%>">修改商品</a></td>
		<td><a href="categoryadd.jsp?id=<%=product.getId()%>">删除商品</a></td>
	</tr>
	<%
		}
	%>
</table>
<!--搜索后前后翻页-->
<center>
	第<%=pageNo%>页 &nbsp; 共<%=pageCount%>页 &nbsp; <a
		href="productsearch.jsp?action=<%=action%>
			&categoryId=<%=strCategoryId%>
			&keyword=<%=URLEncoder.encode(keyword, "utf-8")%>
			&lowNormalPrice=<%=lowNormalPrice%>
			&highNormalPrice=<%=highNormalPrice%>
			&lowMemberPrice=<%=lowMemberPrice%>
			&highMemberPrice=<%=highMemberPrice%>
			&startDate=<%=strStartDate%>
			&endDate=<%=strEndDate%>
			&pageNo=1">首页</a>&nbsp;
	<a
		href="productsearch.jsp?action=<%=action%>
			&categoryId=<%=strCategoryId%>
			&keyword=<%=URLEncoder.encode(keyword, "utf-8")%>
			&lowNormalPrice=<%=lowNormalPrice%>
			&highNormalPrice=<%=highNormalPrice%>
			&lowMemberPrice=<%=lowMemberPrice%>
			&highMemberPrice=<%=highMemberPrice%>
			&startDate=<%=strStartDate%>
			&endDate=<%=strEndDate%>
			&pageNo=<%=pageNo - 1%>">上一页</a>
	&nbsp; <a
		href="productsearch.jsp
			?action=<%=action%>
			&categoryId=<%=strCategoryId%>
			&keyword=<%=URLEncoder.encode(keyword, "utf-8")%>
			&lowNormalPrice=<%=lowNormalPrice%>
			&highNormalPrice=<%=highNormalPrice%>
			&lowMemberPrice=<%=lowMemberPrice%>
			&highMemberPrice=<%=highMemberPrice%>
			&startDate=<%=strStartDate%>
			&endDate=<%=strEndDate%>
			&pageNo=<%=pageNo + 1%>">下一页</a>
	&nbsp; <a
		href="productsearch.jsp?action=<%=action%>
			&categoryId=<%=strCategoryId%>
			&keyword=<%=URLEncoder.encode(keyword, "utf-8")%>
			&lowNormalPrice=<%=lowNormalPrice%>
			&highNormalPrice=<%=highNormalPrice%>
			&lowMemberPrice=<%=lowMemberPrice%>
			&highMemberPrice=<%=highMemberPrice%>
			&startDate=<%=strStartDate%>
			&endDate=<%=strEndDate%>
			&pageNo=<%=pageCount%>">最后一页</a>
</center>
<%
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索商品</title>
<script type="text/javascript">
<!--js 检查数据是否为空-->
	function checkdata() {
		with (document.forms["complex"]) {
			if (lowNormalPrice.value == null || lowNormalPrice.value == "") {
				lowNormalPrice.value = -1;
			}
			if (highNormalPrice.value == null || highNormalPrice.value == "") {
				highNormalPrice.value = -1;
			}
			if (lowMemberPrice.value == null || lowMemberPrice.value == "") {
				lowMemberPrice.value = -1;
			}
			if (highMemberPrice.value == null || highMemberPrice.value == "") {
				highMemberPrice.value = -1;
			}

		}
	}
</script>

</head>
<body>
	<center>简单搜索</center>
	<form action="productsearch.jsp" method="post">
		<input type="hidden" name="action" value="simplexsearch">
		商品类别：<select></select><br> <br> 关键字：<input type="text"
			name="keyword"><br> <br> <input type="submit"
			value="点击搜索">
	</form>
	<br>
	<br>
	<center>简单搜索多类别</center>
	<form action="productsearch.jsp" method="post">
		<input type="hidden" name="action" value="simplexsearch2">
		商品类别：
		<%
			for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
				Category c = it.next();
				if(c.isLeaf()){
				%>
				<br><input type="checkbox" name="categoryId" value="<%=c.getId()%>"> <%=c.getName() %> 
				<%
				}
			}
			%>
		<br> <br>
		关键字：<input type="text" name="keyword"><br> <br> 
		<input type="submit" value="点击搜索">
	</form>
	<br>
	<br>
	<center>复杂搜索</center>
	<form action="productsearch.jsp" method="post" onsubmit="checkdata()"
		name="complex">
		<input type="hidden" name="action" value="complexsearch">

		<table>
			<tr>
				<td>商品类别：</td>
				<td><select name="categoryId">
						<option value="0">所有类别</option>
						<%
							for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
								Category c = it.next();
								String preStr = "--";
								for (int i = 1; i < c.getGrads(); i++) {
									preStr += "--";
								}
						%>
						<option value="<%=c.getId()%>"><%=preStr + c.getName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" name="keyword"></td>
			</tr>

			<tr>
				<td>市场价：</td>
				<td>From:<input type="text" name="lowNormalPrice"> To:<input
					type="text" name="highNormalPrice">

				</td>
			</tr>
			<tr>
				<td>会员价：</td>
				<td>From:<input type="text" name=lowMemberPrice> To:<input
					type="text" name=highMemberPrice>
				</td>
			</tr>
			<tr>
				<td>上架时间：</td>
				<td>From:<input type="text" name=startDate> To:<input
					type="text" name=endDate>
				</td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="搜索"></td>
			</tr>
		</table>
	</form>
</body>
</html>

























