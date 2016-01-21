jQuery.extend({
  getCookie : function(sName) {
    var aCookie = document.cookie.split("; ");
    for (var i=0; i < aCookie.length; i++){
      var aCrumb = aCookie[i].split("=");
      if (sName == aCrumb[0]) return decodeURIComponent(aCrumb[1]);
    }
    return '';
  },
  setCookie : function(sName, sValue, sExpires) {
    var sCookie = sName + "=" + encodeURIComponent(sValue);
    if (sExpires != null) sCookie += "; expires=" + sExpires;
    document.cookie = sCookie;
  },
  removeCookie : function(sName) {
    document.cookie = sName + "=; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
  }
});
function drop_confirm(msg, url){
    if(confirm(msg)){
        window.location = url;
    }
}

/* 显示Ajax表单 */
function ajax_form(id, title, url, width)
{
    if (!width)
    {
        width = 400;
    }
    var d = DialogManager.create(id);
    d.setTitle(title);
    d.setContents('ajax', url);
    d.setWidth(width);
    d.show('center');

    return d;
}
function go(url){
    window.location = url;
}

function change_captcha(jqObj){
    jqObj.attr('src', 'index.php?app=captcha&' + Math.round(Math.random()*10000));
}

/* 格式化金额 */
function price_format(price){
    if(typeof(PRICE_FORMAT) == 'undefined'){
        PRICE_FORMAT = '&yen;%s';
    }
    price = number_format(price, 2);

    return PRICE_FORMAT.replace('%s', price);
}

function number_format(num, ext){
    if(ext < 0){
        return num;
    }
    num = Number(num);
    if(isNaN(num)){
        num = 0;
    }
    var _str = num.toString();
    var _arr = _str.split('.');
    var _int = _arr[0];
    var _flt = _arr[1];
    if(_str.indexOf('.') == -1){
        /* 找不到小数点，则添加 */
        if(ext == 0){
            return _str;
        }
        var _tmp = '';
        for(var i = 0; i < ext; i++){
            _tmp += '0';
        }
        _str = _str + '.' + _tmp;
    }else{
        if(_flt.length == ext){
            return _str;
        }
        /* 找得到小数点，则截取 */
        if(_flt.length > ext){
            _str = _str.substr(0, _str.length - (_flt.length - ext));
            if(ext == 0){
                _str = _int;
            }
        }else{
            for(var i = 0; i < ext - _flt.length; i++){
                _str += '0';
            }
        }
    }

    return _str;
}

/* 收藏商品 */
function collect_goods(id)
{
    var url = SITE_URL + '/index.php?app=my_favorite&act=add&type=goods&ajax=1';
    $.getJSON(url, {'item_id':id}, function(data){
        alert(data.msg);
    });
}

/* 收藏店铺 */
function collect_store(id)
{
    var url = SITE_URL + '/index.php?app=my_favorite&act=add&type=store&jsoncallback=?&ajax=1';
    $.getJSON(url, {'item_id':id}, function(data){
        alert(data.msg);
    });
}
/* 火狐下取本地全路径 */
function getFullPath(obj)
{
    if(obj)
    {
        //ie
        if (window.navigator.userAgent.indexOf("MSIE")>=1)
        {
            obj.select();
            return document.selection.createRange().text;
        }
        //firefox
        else if(window.navigator.userAgent.indexOf("Firefox")>=1)
        {
            if(obj.files)
            {
                return obj.files.item(0).getAsDataURL();
            }
            return obj.value;
        }
        return obj.value;
    }
}

/**
 *    启动邮件队列
 *
 *    @author    Garbin
 *    @param     string req_url
 *    @return    void
 */
function sendmail(req_url)
{
    $(function(){
        var _script = document.createElement('script');
        _script.type = 'text/javascript';
        _script.src  = req_url;
        document.getElementsByTagName('head')[0].appendChild(_script);
    });
}
/* 转化JS跳转中的 ＆ */
function transform_char(str)
{
    if(str.indexOf('&'))
    {
        str = str.replace(/&/g, "%26");
    }
    return str;
} 
//mycart add +  
function dishesadd(){ 
	 var goods_id = $(this).parent().next().attr("id"); //获取id 
    var quantity = parseFloat($(this).prev().val());//获取当前商品的数量 
 	 var priceadd = parseFloat($(this).parent().parent().find("#cur_food_price").html());//获取商品单价 
 	 var cartcount =parseFloat($(".num").html());   //显示购物车总数量 
	 var cartmoney = parseFloat($(".cart_all_money").html());  //购物车总额    
	 var dish_price_new = (cartmoney + priceadd).toFixed(2); 
	 var context = {"flag":'add',"goods_id":goods_id}; 
	 $.ajax({type: "POST",url: "/addtocart/index.html",data: context,success: function(){
		 //增加总数量 +增加总额+增加该商品的数量
		 quantity +=1;//数量+1 
		 $("input[id='"+goods_id+"']").parent().find(".j_count").val(quantity); 
		 cartcount += 1;  //总数量+1 
    	 $(".num").html(cartcount); //总数量增加    
    	 $(".cart_all_money").html(dish_price_new);//总价格增加 
	 }}); 
} 
//mycart sub -
function dishessub(){ 
	 //获取选择的goods_id 
 	 var goods_id = $(this).parent().next().attr("id"); //获取id 
 	 var quantity = parseFloat($(this).next().val());//获取当前商品的数量 
 	 var pricesub = parseFloat($(this).parent().parent().find("#cur_food_price").html());//获取商品单价 
 	 var cartcount =parseFloat($(".num").html());   //显示购物车总数量 
	 var cartmoney = parseFloat($(".cart_all_money").html());  //购物车总额    
	 var dish_price_new = (cartmoney - pricesub).toFixed(2);
	 var cate_name=$(this).attr("cate_name"); 
	 //获取购物车内容  goods_id字段   
	 var mycartgoodsids = $("input[name='mycart_order']").val();   
	 var mycartcateids = $("input[name='mycart_order_cate_id']").val();
	 var context = {"flag":'sub',"goods_id":goods_id}; 
	 $.ajax({type: "POST", url: "/addtocart/index.html",data: context,success: function(){
		quantity -=1;//数量-1 
		if(quantity <=0){
			var dd = $("input[id='"+goods_id+"']").parent().remove(); //dd
			//减去容器中的goods_id
			var re =new RegExp(goods_id,"g"); 
			mycartgoodsids = mycartgoodsids.replace(re,''); 
			$("input[name='mycart_order']").val(mycartgoodsids); 
			if( $(".menu_lists").find("dl[name='"+cate_name+"'] dd").length <=0 ){
					//该分类下面没有菜品了,删除容器中的分类名字以及去除此dl
					//减去容器中的goods_id
	   				var re =new RegExp(cate_name,"g"); 
	   				mycartcateids = mycartcateids.replace(re,'');
	   				$("input[name='mycart_order_cate_id']").val(mycartcateids); 
	   				$(".menu_lists").find("dl[name='"+cate_name+"']").remove(); 
				} 
		//控制 .submit_warp 显示金额数量界面   
		}  
		$("input[id='"+goods_id+"']").parent().find(".j_count").val(quantity); 
		cartcount -= 1;  //总数量-1 
		if(cartcount <=0){
			//控制 .submit_warp 显示金额数量界面 
			$(".submit_warp").hide(); //hide
			cartcount = 0;
		} 
		$(".num").html(cartcount); //总数量-
		if (dish_price_new <=0){
			dish_price_new =0;
		}
		$(".cart_all_money").html(dish_price_new);//总价格-
	}});
}
//mycart add +  
function dishesaddcart(){ 
	 var goods_id = $(this).parent().next().attr("id"); //获取id 
     var quantity = parseFloat($(this).prev().val());//获取当前商品的数量 
 	 var priceadd = parseFloat($(this).parent().parent().find("#cur_food_price").html());//获取商品单价 
 	 var cartcount =parseFloat($(".num").html());   //显示购物车总数量 
	 var cartmoney = parseFloat($(".cart_all_money").html());  //购物车总额    
	 var dish_price_new = (cartmoney + priceadd).toFixed(2); 
	 var context = {"flag":'add',"goods_id":goods_id}; 
	 $.ajax({type: "POST",url: "/addtocart/index.html",data: context,success: function(){
		 //增加总数量 +增加总额+增加该商品的数量
		 quantity +=1;//数量+1 
		 $("input[id='"+goods_id+"']").parent().find(".j_count").val(quantity); 
		 cartcount += 1;  //总数量+1 
    	 $(".num").html(cartcount); //总数量增加    
    	 $(".cart_all_money").html(dish_price_new);//总价格增加 
    	 isEnough(dish_price_new);
	 }}); 
	 
} 
//mycart sub -
function dishessubcart(){ 
	 //获取选择的goods_id 
 	 var goods_id = $(this).parent().next().attr("id"); //获取id 
 	 var quantity = parseFloat($(this).next().val());//获取当前商品的数量 
 	 var pricesub = parseFloat($(this).parent().parent().find("#cur_food_price").html());//获取商品单价 
 	 var cartcount =parseFloat($(".num").html());   //显示购物车总数量 
	 var cartmoney = parseFloat($(".cart_all_money").html());  //购物车总额    
	 var dish_price_new = (cartmoney - pricesub).toFixed(2);
	 var cate_name=$(this).attr("cate_name"); 
	 //获取购物车内容  goods_id字段   
	 var mycartgoodsids = $("input[name='mycart_order']").val();   
	 var mycartcateids = $("input[name='mycart_order_cate_id']").val();
	 var context = {"flag":'sub',"goods_id":goods_id}; 
	 $.ajax({type: "POST", url: "/addtocart/index.html",data: context,success: function(){
		quantity -=1;//数量-1 
		if(quantity <=0){
			//
			var dd = $("input[id='"+goods_id+"']").parent().remove(); //dd
			
			//减去容器中的goods_id
			var re =new RegExp(goods_id,"g"); 
			mycartgoodsids = mycartgoodsids.replace(re,''); 
			$("input[name='mycart_order']").val(mycartgoodsids); 
			
			if( $(".menu_lists").find("dl[name='"+cate_name+"'] dd").length <=0 ){
					//该分类下面没有菜品了,删除容器中的分类名字以及去除此dl
					//减去容器中的goods_id
	   				var re =new RegExp(cate_name,"g"); 
	   				mycartcateids = mycartcateids.replace(re,'');
	   				$("input[name='mycart_order_cate_id']").val(mycartcateids); 
	   				$(".menu_lists").find("dl[name='"+cate_name+"']").remove(); 
				} 
		//控制 .submit_warp 显示金额数量界面   
		}  
		if (dish_price_new <=0){
			dish_price_new =0;
		} 
		$(".cart_all_money").html(dish_price_new);//总价格- 
		$("input[id='"+goods_id+"']").parent().find(".j_count").val(quantity); 
		cartcount -= 1;  //总数量-1 
		if(cartcount <=0){ // =1
			//控制 .submit_warp 显示金额数量界面  清空总额 总数量 
			$(".num").html('0'); //总数量为0      
		    $(".cart_all_money").html('0');//总价格为0
		    
			$(".submit_warp").hide(); //hide
			cartcount = 0;
		}
		$(".num").html(cartcount); //总数量- 
		isEnough(dish_price_new);
	}}); 
}// end sub 
