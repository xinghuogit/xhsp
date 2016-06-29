<%@page import="com.xh.shopping.model.Cart"%>
<%@page import="com.xh.shopping.util.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.xh.shopping.manage.CartMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String strId = request.getParameter("userid");
	int id = -1;
	List<Cart> carts = null;

	if (!StringUtil.isEmpty(strId)) {
		id = Integer.parseInt(strId);
		carts = CartMgr.getInstance().getCarts(id);
	}

	if (carts == null || carts.size() <= 0) {
		out.println("购物车没有任何商品");
		return;
	}

	for (int i = 0; i < carts.size(); i++) {
		Cart item = carts.get(i);
		String strCount = request
		.getParameter(item.getProductid() + "");
		if (!StringUtil.isEmpty(strCount)) {
			int count = Integer.parseInt(strCount);
			item.setCount(count);
			CartMgr.getInstance().updateCart(item);
		}
	}
%>

修改成功
<span id="time" style="">3</span>
秒钟后自动跳转，如果浏览器不支持，请点击下面链接 <
<script type="text/javascript">
	function delayURl(url) {
		var delay = document.getElementById("time").innerHTML;
		if (delay > 0) {
			delay--;
			document.getElementById("time").innerHTML = delay;
		} else {
			window.top.location.href = url;
		}
		setTimeout("delayURl('" + url + "')", 1000);
	}
</script>


<a href="cart.jsp?userid=" + <%=id%>>购物车</a>
<script>
	delayURl("cart.jsp?userid=" +<%=id%>);
</script>