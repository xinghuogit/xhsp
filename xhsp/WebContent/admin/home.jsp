<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="skin/default/skin.css" rel="stylesheet" type="text/css"
	id="skin" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet"
	type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="images/logo.ico">
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>欢迎进入管理平台！</title>
</head>
<body>
	<header class="Hui-header cl" style="background: #507dcf;">
		<a class="Hui-logo l" style="display: block; color: #fff;">智慧消防管理平台
			S2.0</a>



		<ul class="Hui-userbar">

			<li class="dropDown dropDown_hover"><a href="#"
				class="dropDown_A" style="display: block; color: #fff;">李明 <i
					class="Hui-iconfont">&#xe6d5;</i></a>
				<ul class="dropDown-menu radius box-shadow">
					<li><a href="#">个人信息</a></li>
					<li><a href="#">切换账户</a></li>
					<li><a href="#">退出</a></li>
				</ul></li>
		</ul>
		<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a>
	</header>
	<aside class="Hui-aside">
		<input runat="server" id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<dl id="menu-article">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 类别管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>

						<li><a _href="categoryadd.jsp" href="javascript:void(0)">添加类别</a></li>
					</ul>
					<ul>

						<li><a _href="car.html" href="javascript:void(0)">类别列表</a></li>
					</ul>
				</dd>
			</dl>


			<dl id="menu-article">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 监控管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>

						<li><a _href="car.html" href="javascript:void(0)">监控管理</a></li>
					</ul>
					<ul>

						<li><a _href="car.html" href="javascript:void(0)">监控管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-article">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 视频管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="map.html" href="javascript:void(0)">视频管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 警情管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="alarm-1.html" href="javascript:void(0)">警情管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-product">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 故障管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="fault-1.html" href="javascript:void(0)">故障管理</a></li>
					</ul>
				</dd>
			</dl>

			<dl id="menu-comments">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 设备管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="equipment-1.html" href="javascript:;">设备管理</a></li>
						<li><a _href="equipment-2.html" href="javascript:void(0)">设备分类管理</a></li>
						<li><a _href="equipment-3.html" href="javascript:;">部件管理</a></li>
						<li><a _href="equipment-4.html" href="javascript:void(0)">部件分类管理</a></li>
					</ul>
				</dd>
			</dl>

			<dl id="menu-member">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 单位管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="unit-1.html" href="javascript:;">单位管理</a></li>
						<li><a _href="unit-2.html" href="javascript:;">单位分类管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-admin">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 建筑管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="building-1.html" href="javascript:void(0)">建筑管理</a></li>
						<li><a _href="building-2.html" href="javascript:void(0)">建筑分类管理</a></li>
						<li><a _href="building-3.html" href="javascript:void(0)">建筑群管理</a></li>
						<li><a _href="building-4.html" href="javascript:void(0)">建筑群分类管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-tongji">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 平台管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="terrace-1.html" href="javascript:void(0)">公告管理</a></li>
						<li><a _href="terrace-2.html" href="javascript:void(0)">新闻管理</a></li>
						<li><a _href="terrace-3.html" href="javascript:void(0)">资讯档案管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-system">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 统计数据<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="charts-1.html" href="javascript:void(0)">监控统计</a></li>
						<li><a _href="charts-2.html" href="javascript:void(0)">服务统计</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-admin">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 角色管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="role-1.html" href="javascript:void(0)">管理员管理</a></li>
						<li><a _href="role-2.html" href="javascript:void(0)">会员管理</a></li>
						<li><a _href="role-3.html" href="javascript:void(0)">运营商管理</a></li>
						<li><a _href="role-4.html" href="javascript:void(0)">角色管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-system">
				<dt>
					<i class="Hui-iconfont">&#xe601;</i> 操作日志<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a _href="record.html" href="javascript:void(0)">操作日志</a></li>
					</ul>
				</dd>
			</dl>
		</div>
	</aside>
	<div class="dislpayArrow">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"
			style="background-image: url(images/icon_arrow.png);"></a>
	</div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="监控地图" data-href="welcome.html">监控地图</span><em></em></li>
				</ul>
				<div class="weather">
					<iframe width="260" scrolling="no" height="25" frameborder="0"
						allowtransparency="true"
						src="http://i.tianqi.com/index.php?c=code&id=34&icon=1&num=3"></iframe>
				</div>

			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="map.html"></iframe>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="js/H-ui.js"></script>
	<script type="text/javascript" src="js/H-ui.admin.js"></script>
	<script type="text/javascript">
		/*资讯-添加*/
		function article_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		/*图片-添加*/
		function picture_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		/*产品-添加*/
		function product_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		/*用户-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
	</script>
	<script type="text/javascript">
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s)
		})();
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
	</script>
</body>
</html>