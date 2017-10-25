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
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h6>最新加入的商品</h6>
		<c:forEach items="${list_cart}" var="cart">
			<div class="one">
				<img src="${pageContext.request.contextPath }/upload/image/${cart.shp_tp}" width="70px"/>
				<span class="one_name">
					${cart.sku_mch}
				</span>
				<span class="one_prece">
					<b>￥${cart.sku_jg}</b><br />
					&nbsp;&nbsp;&nbsp;删除
				</span>
			</div>
		</c:forEach>
		<div class="gobottom">
			共<span>2</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
			共计￥<span>20000</span>
			<button class="goprice">去购物车</button>
		</div>
</body>
</html>