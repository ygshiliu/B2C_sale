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
function sale_change_cart(checked,tjshl,sku_id){
	if(checked){
		checked = "1";
	}else{
		checked = "0";
	}
		$.post("change_cart.do",{shfxz:checked,tjshl:tjshl,sku_id:sku_id},function (data){
		$("#sale_cart_list_inner").html(data);
	}); 
}
</script>
</head>
<body>
	购物车列表${test}<br>
	<c:forEach items="${list_cart}" var="cart">
		<input onclick="sale_change_cart(this.checked,-1,${cart.sku_id})" type="checkbox" ${cart.shfxz=="1"?"checked":""} /><img src="upload/image/${cart.shp_tp}" width="100px">${cart.sku_mch}  ${cart.sku_jg}  
		<a href="javascript:sale_change_cart(0,${cart.tjshl-1},${cart.sku_id});">-</a>
		${cart.tjshl}
		<a href="javascript:sale_change_cart(0,${cart.tjshl+1},${cart.sku_id});">+</a>
		<br>
	</c:forEach>
</body>
</html>