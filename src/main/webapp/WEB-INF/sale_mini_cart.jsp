<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
<link rel="shortcut icon" type="image/icon" href="images/jd.ico">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
		function miniCart_show(){
			$.get("get_miniCart.do",function(data){
				$("#miniCart_cart_list").html(data);
			});
			$("#miniCart_cart_list").show();
			return false;
		}
		
		function miniCart_hide(){
			$("#miniCart_cart_list").hide();
		}
</script>
</head>
<body>
		<div class="card" onmouseover="miniCart_show()" onmouseout="miniCart_hide()">
			<a target="_blank" href="${pageContext.request.contextPath }/goto_cart_list.do"  >购物车<div class="num">0</div></a>
			<!--购物车商品-->
			<div id="miniCart_cart_list" class="cart_pro"></div>
		</div>
</body>
</html>