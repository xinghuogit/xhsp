<%@page import="java.util.Iterator"%>
<%@page import="com.xh.shopping.manage.ProductMgr"%>
<%@page import="com.xh.shopping.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int count = 10;
	List<Product> products = ProductMgr.getInstance().getLatestProducts(count);
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta http-equiv="X-UA-Compatible"
		content="IE=EmulateIE7 charset=utf-8">

		<title>商城有你所有</title>
		<meta name="description" content="商城有你所有">
			<meta name="keywords" content="商城有你所有">
				<link href="./image/ecmall.css" rel="stylesheet" type="text/css">
					<script type="text/javascript">
						//<!CDATA[
						var SITE_URL = "http://www.ttuhui.com";
						var REAL_SITE_URL = "http://cd.ttuhui.com";
						var PRICE_FORMAT = '¥%s';
					</script>
					<script type="text/javascript" src="./image/index.php"></script>
					<script type="text/javascript" src="./image/jquery.js"
						charset="utf-8"></script>
					<script type="text/javascript" src="./image/ecmall.js"
						charset="utf-8"></script>
					<script type="text/javascript" src="./image/member.js"
						charset="utf-8"></script>
					<script type="text/javascript" src="./image/jquery.from.js"
						charset="utf-8"></script>
					<script type="text/javascript" src="./image/jquery.slideBox.min.js"
						charset="utf-8"></script>
					<script type="text/javascript">
						$(function() {
							$(".head_top a.app_down").hover(
									function() {
										$(this).find(".QuickMark").css(
												"display", "block");
									},
									function() {
										$(this).find(".QuickMark").css(
												"display", "none");
									});
						});
					</script>
</head>
<body>
	<div id="head">
		<div class="head_top_bg">
			<div class="center head_top">
				<div class="left">
					<a href="./image/天天U惠-实体店的专属门户.htm">首 页</a> <i class="spit_d6"></i>
					<a href="http://www.36ht.com/" title="成都商联汇通信息技术有限公司">商联汇通</a>
				</div>
				<div class="right">
					<a href="http://ucenter.ttuhui.com/member/login.html?ret_url="
						class="login">登录</a> <i class="spit_d6"></i> <a
						href="http://ucenter.ttuhui.com/member/register.html?ret_url="
						class="register">免费注册</a> <i class="spit_d6"></i> <a
						href="http://cd.ttuhui.com/page/appdown.html" class="app_down">
						<i class="icon phone"></i>APP下载
						<div class="QuickMark">
							<img src="./image/QuickMark.png" width="120" height="120"
								alt="手机APP">
						</div>
					</a> <i class="spit_d6"></i> <a
						href="http://cd.ttuhui.com/message/newpm.html" target="_blank">
						消息中心 </a> <i class="spit_d6"></i> <a
						href="http://ucenter.ttuhui.com/member/profile.html" class="cart">
						<i class="icon cart"></i>用户中心
					</a>
				</div>
			</div>
		</div>
		<div class="center">
			<div class="head_middle">
				<div class="logo left">
					<a href="http://www.ttuhui.com/"><img
						src="./image/site_logo.png" alt="天天U惠-实体店的专属门户"></a>
				</div>
				<div class="search right">
					<div class="region">
						<a href="http://cd.ttuhui.com/city/index.html" title="切换城市">成都
							<i class="icon search_i"></i>
						</a>
					</div>
					<div class="search_box">
						<form action="http://cd.ttuhui.com/search/index.html" method="get">
							<input type="text" name="keyword" id="kerword" class="keyword"
								value=""><input type="submit" name="submit"
								class="search_sub" value="">
						</form>
					</div>
				</div>
			</div>
			<div class="head_bottom">
				<div class="nav left">
					<ul class="nav_l">
						<li class="no_border active"><a
							href="./image/天天U惠-实体店的专属门户.htm">首 页 <i class="icon nav_i"></i>
						</a></li>
						<li class=""><a href="http://cd.ttuhui.com/dishes/index.html">
								<i class="icon hot">HOT</i>点餐 <i class="icon nav_i"></i>
						</a></li>
						<li class=""><a
							href="http://cd.ttuhui.com/dishes/takeout.html"> 外卖 <i
								class="icon nav_i"></i>
						</a></li>
						<li class=""><a href="http://cd.ttuhui.com/search/index.html">
								优 惠 <i class="icon nav_i"></i>
						</a></li>
						<li class=""><a href="http://cd.ttuhui.com/search/store.html">
								<i class="icon hot">NEW</i>商 户 <i class="icon nav_i"></i>
						</a></li>
						<li class=""><a href="http://cd.ttuhui.com/map/index.html">地
								图 <i class="icon nav_i"></i>
						</a></li>
					</ul>
				</div>
				<div class="nav right">
					<ul class="nav_r">
						<li class="no_border phone_app"><i class="icon new"></i><a
							href="http://cd.ttuhui.com/page/appdown.html"> 手机APP</a></li>
						<li><a
							href="http://cd.ttuhui.com/article/system.html?code=cooperation">加盟天天</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="banner center">
			<div id="index_view" class="slideBox"
				style="width: 765px; height: 355px;">
				<ul class="items" style="width: 3825px; left: -765px;">
					<li class="active" style="width: 765px; height: 355px;"><a
						href="" title=""><img src="./image/focus1.jpg" alt="广告一"></a></li>
					<li class="" style="width: 765px; height: 355px;"><a href=""
						title=""><img src="./image/focus2.jpg" alt="广告二"></a></li>
					<li style="width: 765px; height: 355px;" class=""><a href=""
						title=""><img src="./image/focus3.jpg" alt="广告三"></a></li>
					<li style="width: 765px; height: 355px;" class=""><a href=""
						title=""><img src="./image/focus4.jpg" alt="广告四"></a></li>
					<li style="width: 765px; height: 355px;" class=""><a href=""
						title=""><img src="./image/focus5.jpg" alt="广告五"></a></li>
				</ul>
			</div>
			<div class="content_banner_ul">
				<ul>
					<li><a href="http://cd.ttuhui.com/store/join.html"><img
							src="./image/chinaums_join.jpg" alt="银联商务商户入驻"></a></li>
					<!-- <li>
					<a href="/search/store.html?cate_id=6"><img src="http://img.ttuhui.com/data/exhibition/category/focus1-1.jpg" alt="购物"></a>
				</li> -->
					<li><a href="http://cd.ttuhui.com/search/store.html?cate_id=1"><img
							src="./image/focus1-2.jpg" alt="美食"></a></li>
					<li><a href="http://cd.ttuhui.com/search/store.html?cate_id=4"><img
							src="./image/focus1-3.jpg" alt="生活服务"></a></li>
					<li><a
						href="http://cd.ttuhui.com/search/store.html?cate_id=13"><img
							src="./image/focus1-4.jpg" alt="美容保健"></a></li>
					<li><a href="http://cd.ttuhui.com/search/store.html?cate_id=3"><img
							src="./image/focus1-5.jpg" alt="休闲娱乐"></a></li>
					<li><a href="http://cd.ttuhui.com/search/store.html?cate_id=2"><img
							src="./image/focus1-6.jpg" alt="酒店"></a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="discount">
		<div class="discount_list center">
			<div class="discount_title today"></div>
			<div class="discount_list_info">
				<div class="discount_list_big">
					<a href="http://cd.ttuhui.com/goods/111.html" title="来福士巴国布衣"
						target="_blank"><img src="./image/now_img1.jpg" alt="来福士巴国布衣"></a>
				</div>
				<div class="discount_list_big">
					<a href="http://cd.ttuhui.com/goods/73.html" title="好莱斯登酒店"
						target="_blank"><img src="./image/now_img2.jpg" alt="好莱斯登酒店"></a>
				</div>
				<div class="discount_list_small">
					<a href="http://cd.ttuhui.com/goods/109.html" title="聚源家宴餐馆"
						target="_blank"><img src="./image/now_img3.jpg" alt="聚源家宴餐馆"></a>
				</div>
				<div class="discount_list_small">
					<a href="http://cd.ttuhui.com/goods/106.html" title="成都康普雷斯国际酒店"
						target="_blank"><img src="./image/now_img4.jpg"
						alt="成都康普雷斯国际酒店"></a>
				</div>
				<div class="discount_list_small">
					<a href="http://cd.ttuhui.com/goods/124.html" title="宽坐餐饮"
						target="_blank"><img src="./image/now_img5.jpg" alt="宽坐餐饮"></a>
				</div>
				<div class="discount_list_small">
					<a href="http://cd.ttuhui.com/goods/110.html" title="阿拉丁国际儿童摄影"
						target="_blank"><img src="./image/now_img6.jpg"
						alt="阿拉丁国际儿童摄影"></a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="shop center">
			<div class="discount_title new_shop">
				<a href="http://cd.ttuhui.com/search/store.html" target="_blank"
					title="更多商户">更多 &gt;</a>
			</div>
			<!-- 最新商品开始 -->
			<div class="store_list">
				<ul>
					<%
						if(products!=null && products.size()>0) {
									   for(Iterator<Product> it = products.iterator(); it.hasNext();){
										   Product product = it.next();
					%>
					<li><a href="productdetailshow.jsp?id=<%=product.getId() %>"
						title="<%=product.getName()%>" target="_blank"><img
							src="./image/store_logo.png_c292x292" alt="<%=product.getName()%>"></a>
						<div class="store_list_info">
							<p class="store_list_tilte">
								<a href="http://cd.ttuhui.com/store/213.html"
									title="<%=product.getName()%>" target="_blank"><%=product.getName()%></a>
							</p>
							<p class="store_list_adress diandian">地址：</p>
							<p class="store_list_num">
								会员价：<em><%=product.getMemberPrice()%>￥</em>
							</p>
						</div></li>
					<%
						}
												}
					%>
				</ul>
				<div class="clear"></div>
			</div>
			<!-- 最新商品结束 -->
			<div class="discount_title left dc_goods"></div>
			<div class="screen">
				<div class="screen_item">
					<div class="shop_act_title">分类</div>
					<ul class="shop_act">
						<li><a href="">全部</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=2"
							target="_blank">美食</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=3"
							target="_blank">酒店</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=4"
							target="_blank">休闲娱乐</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=5"
							target="_blank">生活服务</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=7"
							target="_blank">购物</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=8"
							target="_blank">电影</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=9"
							target="_blank">美容保健</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?cate_id=13"
							target="_blank">其他</a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="screen_item">
					<div class="shop_act_title">地区</div>
					<ul class="shop_act">
						<li><a href="">全部</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=4"
							target="_blank">高新区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=5"
							target="_blank">武侯区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=6"
							target="_blank">金牛区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=7"
							target="_blank">青羊区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=8"
							target="_blank">锦江区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=9"
							target="_blank">成华区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=11"
							target="_blank">龙泉驿区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=29"
							target="_blank">青白江区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=30"
							target="_blank">新都区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=31"
							target="_blank">温江区</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=32"
							target="_blank">金堂县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=33"
							target="_blank">双流县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=34"
							target="_blank">郫县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=35"
							target="_blank">大邑县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=36"
							target="_blank">蒲江县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=37"
							target="_blank">新津县</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=38"
							target="_blank">都江堰市</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=39"
							target="_blank">彭州市</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=40"
							target="_blank">邛崃市</a></li>
						<li><i class="spit_67"></i><a
							href="http://cd.ttuhui.com/search/index.html?region_id=41"
							target="_blank">崇州市</a></li>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="shop_list">
				<ul>
				</ul>
				<div class="clear"></div>
			</div>
			<div class="bank_card">
				<div class="bank_service">
					<div class="bs_title"></div>
					<ul class="bs_item">
						<li class="online_check"><a
							href="http://service.chinaums.com/uis/uisWebLogin/login;JSESSIONID=chinaums-newuis-4831cfe2-97d1-4e11-98c5-6dbccda512ed"
							rel="nofollow" target="_blank">在线对账 &gt;&gt;</a></li>
						<li class="online_single"><a href="http://www.sc-ums.com/">银联商务
								&gt;&gt;</a></li>
						<li class="apply_pos"><a href="">申请POS &gt;&gt;</a></li>
					</ul>
					<div class="small_class">
						<img src="./image/small_class.png" width="221" height="120">
					</div>
				</div>
				<div class="cooperation">
					<div class="cot_title"></div>
					<ul class="bank_list">
						<li><img src="./image/abchina.jpg" width="129" height="42"
							alt="农业银行"></li>
						<li><img src="./image/bankcomm.jpg" width="129" height="42"
							alt="交通银行"></li>
						<li><img src="./image/bankofshanghai.jpg" width="129"
							height="42" alt="上海银行"></li>
						<li><img src="./image/boc.jpg" width="129" height="42"
							alt="中国银行"></li>
						<li><img src="./image/ccb.jpg" width="129" height="42"
							alt="建设银行"></li>
						<li><img src="./image/cdrcb.jpg" width="129" height="42"
							alt="成都农商银行"></li>
						<li><img src="./image/cebbank.jpg" width="129" height="42"
							alt="光大银行"></li>
						<li><img src="./image/cgbchina.jpg" width="129" height="42"
							alt="广东发展银行"></li>
						<li><img src="./image/cib.jpg" width="129" height="42"
							alt="兴业银行"></li>
						<li><img src="./image/cmbc.jpg" width="129" height="42"
							alt="民生银行"></li>
						<li><img src="./image/cmbchina.jpg" width="129" height="42"
							alt="招商银行"></li>
						<li><img src="./image/cqcbank.jpg" width="129" height="42"
							alt="重庆银行"></li>
						<li><img src="./image/czbank.jpg" width="129" height="42"
							alt="浙商银行"></li>
						<li><img src="./image/ecitic.jpg" width="129" height="42"
							alt="中信银行"></li>
						<li><img src="./image/hangseng.jpg" width="129" height="42"
							alt="恒丰银行"></li>
						<li><img src="./image/hkbea.jpg" width="129" height="42"
							alt="东亚银行"></li>
						<li><img src="./image/hrbcb.jpg" width="129" height="42"
							alt="哈尔滨银行"></li>
						<li><img src="./image/hxb.jpg" width="129" height="42"
							alt="华夏银行"></li>
						<li><img src="./image/icbc.jpg" width="129" height="42"
							alt="工商银行"></li>
						<li><img src="./image/psbc.jpg" width="129" height="42"
							alt="中国邮政"></li>
						<li><img src="./image/pzhccb.jpg" width="129" height="42"
							alt="攀枝花市商业银行"></li>
						<li><img src="./image/spdb.jpg" width="129" height="42"
							alt="浦东发展银行"></li>
						<li><img src="./image/standardchartered.jpg" width="129"
							height="42" alt=""></li>
						<li><img src="./image/tccb.jpg" width="129" height="42"
							alt="天津银行"></li>
						<li><img src="./image/cbhb.jpg" width="129" height="42"
							alt="渤海银行"></li>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
			<div class="index_bottom">
				<ul>
					<li class="server">
						<p class="ib_tit">一对一</p>
						<p class="ib_con">贴心商户服务</p>
					</li>
					<li class="support">
						<p class="ib_tit">技术支持</p>
						<p class="ib_con">提升商户销售数据</p>
					</li>
					<li class="alltime">
						<p class="ib_tit">随身优惠</p>
						<p class="ib_con">无线平台享受便利</p>
					</li>
					<li class="push">
						<p class="ib_tit">定位推送</p>
						<p class="ib_con">商品信息有的放失</p>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div id="footer">
		<div class="footer_nav">
			<div class="center">
				<!--<dl>
				<dt>商务合作</dt>
				<dd><a href="" target="_blank">商家入驻</a></dd>
				<dd><a href="" target="_blank">友情链接</a></dd>
			</dl>
			<dl>
				<dt>公司信息</dt>
				<dd><a href="/article/system.html?code=about" target="_blank">关于我们</a></dd>
				<dd><a href="" target="_blank">加盟须知</a></dd>
				<dd><a href="" target="_blank">法律声明</a></dd>
				<dd><a href="" target="_blank">用户协议</a></dd>
			</dl>
			<dl>
				<dt>用户帮助</dt>
				<dd><a href="" target="_blank">常见问题</a></dd>
				<dd><a href="" target="_blank">售后服务</a></dd>
				<dd><a href="" target="_blank">新手上路</a></dd>
			</dl>-->
				<a href="http://cd.ttuhui.com/article/system.html?code=about">关于我们</a>
				<i class="spit_c6"></i> <a href="">新手帮助</a> <i class="spit_c6"></i>
				<a href="http://cd.ttuhui.com/article/system.html?code=cooperation">商户入驻</a>
				<i class="spit_c6"></i> <a href="">客户服务</a> <i class="spit_c6"></i>
			</div>
		</div>
		<div class="footer_info">
			<div class="center">
				<div class="bottom_logo">
					<img src="./image/bottom_logo.png" alt="天天优惠">
				</div>
				<div class="info_right">
					<p>成都商联汇通信息技术有限公司</p>
					<p>地址：成都市高新区天顺路288号</p>
					<p>2014-2015 © 天天U惠 ttuhui.com 蜀ICP备14006312号-1
						电信经营许可证:川B2-20140174</p>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#index_view').slideBox({
				duration : 0.8,
				delay : 9,
				hideBottomBar : true
			//隐藏底栏
			});
		});
	</script>
	<div
		style="position: static; width: 0px; height: 0px; border: none; padding: 0px; margin: 0px;">
		<div id="trans-tooltip">
			<div id="tip-left-top"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-left-top.png); background-position: initial initial; background-repeat: initial initial;"></div>
			<div id="tip-top"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-top.png); background-position: initial initial; background-repeat: repeat no-repeat;"></div>
			<div id="tip-right-top"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-right-top.png); background-position: initial initial; background-repeat: initial initial;"></div>
			<div id="tip-right"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-right.png); background-position: initial initial; background-repeat: no-repeat repeat;"></div>
			<div id="tip-right-bottom"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-right-bottom.png); background-position: initial initial; background-repeat: initial initial;"></div>
			<div id="tip-bottom"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-bottom.png); background-position: initial initial; background-repeat: repeat no-repeat;"></div>
			<div id="tip-left-bottom"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-left-bottom.png); background-position: initial initial; background-repeat: initial initial;"></div>
			<div id="tip-left"
				style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-left.png); background-position: initial initial; background-repeat: initial initial;"></div>
			<div id="trans-content"></div>
		</div>
		<div id="tip-arrow-bottom"
			style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-arrow-bottom.png); background-position: initial initial; background-repeat: initial initial;"></div>
		<div id="tip-arrow-top"
			style="background-image: url(chrome-extension://ikkepelhgbcgmhhmcmpfkjmchccjblkd/imgs/map/tip-arrow-top.png); background-position: initial initial; background-repeat: initial initial;"></div>
	</div>
</body>
</html>