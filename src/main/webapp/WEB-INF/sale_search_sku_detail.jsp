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
	
</script>
</head>
<body>
	<img width="100px" height="100px" alt="" src="${pageContext.request.contextPath }/upload/image/${sku_detail.t_mall_product.shp_tp }">
	<br>
	sku名称 ： ${sku_detail.sku_mch }<br>
	价格 ： ${sku_detail.jg }<br>
	库存 ： ${sku_detail.kc}<br>
	<hr>
		其它规格商品：<br>
		<c:forEach items="${sku_list }" var="sku">
			<a href="${pageContext.request.contextPath }/get_sku_by_id.do?sku_id=${sku.id}&spu_id=${sku.shp_id}">
				${sku.sku_mch }
			</a>
			<br>
		</c:forEach>
		
	<hr>
	<form action="${pageContext.request.contextPath }/add_sku_to_cart.do" method="post">
		<input type="text" name="sku_mch" value="${sku_detail.sku_mch }"/>             <br>
		<input type="text" name="sku_jg" value="${sku_detail.jg}"/>                    <br>
		<input type="text" name="tjshl" value="1"/>                                    <br>
		<input type="text" name="hj" value="${sku_detail.jg}"/>                        <br>
		<input type="text" name="shp_id" value="${sku_detail.shp_id}"/>                <br>
		<input type="text" name="sku_id" value="${sku_detail.id}"/>                    <br>
		<input type="text" name="shp_tp" value="${sku_detail.t_mall_product.shp_tp}"/> <br>
		<input type="text" name="kcdz" value="${sku_detail.kcdz}"/>                    <br>
		<input type="submit" value="添加购物车">
	</form>
	<hr>
	商品规格：<br>
	<c:forEach items="${sku_detail.attr_list }" var="attr">
		${attr.shxm_mch }：
		<c:forEach items="${attr.list_value }" var="val">
			${val.shxzh_mch }
		</c:forEach>
		<br>
	</c:forEach>
	<hr>
	名称 ： ${sku_detail.t_mall_product.shp_mch }<br>
	<c:forEach items="${sku_detail.product_image_list }" var="img">
		<img alt="" src="${pageContext.request.contextPath }/upload/image/${img.url}" width="100px" height="100px">
	</c:forEach>
	
</body>
</html>