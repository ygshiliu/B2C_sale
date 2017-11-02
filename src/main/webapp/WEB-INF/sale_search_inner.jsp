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
	<hr>
	<c:forEach items="${sku_list }" var="sku">
		<a href="${pageContext.request.contextPath }/get_sku_by_id.do?sku_id=${sku.id}&spu_id=${sku.shp_id}" target="_blank">
		<div style="border: grey 1px solid;float:left;width:150px;height:190px;margin-left:20px;padding-top:10px;margin-top:20px;text-align:center;">
			<img alt="" src="upload/image/${sku.t_mall_product.shp_tp }" width="100px"><br>
			${sku.sku_mch }<br>
			${sku.jg }
		</div>
		</a>
	</c:forEach>
	
</body>
</html>