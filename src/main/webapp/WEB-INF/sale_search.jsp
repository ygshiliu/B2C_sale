<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">

	function search_sku_attr_up(shxm_id,shxzh_id,obj){
		$("#show_attr_eare_"+shxm_id).hide();
		 $("#search_sku_attr_eare").append("<input id='attr_"+shxm_id+"' onclick='search_sku_attr_down("+shxm_id+")' type='text' name='attr' value='{\"shxm_id\":"+shxm_id+",\"shxzh_id\":"+shxzh_id+"}'/>")
		 get_sku_by_attr();
	}
	function search_sku_attr_down(shxm_id){
		$("#show_attr_eare_"+shxm_id).show();
		$("#attr_"+shxm_id).remove();
	}
	
	function get_sku_by_attr(){
		var query="";
		var attr = $("#search_sku_attr_eare [name='attr']");
		attr.each(function(i,item){
			var jsonstr = $(item).val();
			var json = $.parseJSON(jsonstr);
			query+="list_attr_value["+i+"].shxm_id="+json.shxm_id+"&list_attr_value["+i+"].shxzh_id="+json.shxzh_id+"&";
		})
		var order = $("#search_sku_attr_eare [name='order']").val();
		var class_2_id =${class_2_id};
		query+="order="+order+"&class_2_id="+class_2_id;
		
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/get_sku_by_attr.do",
			data:query,
			success:function(data){
				$("#search_inner").html(data);
			}
		})
	}
	
	function search_sku_order(order){
		var old_order = $("#search_sku_attr_eare [name='order']").val();
		if(old_order == order){
			order += " desc ";
		}
		 $("#search_sku_attr_eare [name='order']").val(order);
		 get_sku_by_attr();
	}
</script>
</head>
<body>
	<b>${class_2_name }></b>${class_2_id }<br><br>
	<hr>
		<div id="search_sku_attr_eare">
			<input type="text" name="order" value=" order by sku.id "/>
		</div>
	<hr>
	<c:if test="${!empty attrList }">
		 	<c:forEach items="${attrList }" var="attr">
		 		<div id="show_attr_eare_${attr.id }">
				"${attr.shxm_mch }" 属性：
				<c:forEach items="${attr.list_value }" var="attr_value" varStatus="index">
					<a href="javascript:search_sku_attr_up(${ attr.id},${attr_value.id});">${attr_value.shxzh }${attr_value.shxzh_mch }</a>&nbsp;&nbsp;&nbsp;
				</c:forEach>
				</div>
			</c:forEach> 
	</c:if>
	<hr>
		<dir>商品排序：
			<a href="javascript:search_sku_order(' order by sku_xl ');">销量优先</a>
			<a href="javascript:search_sku_order(' order by jg ');">价格</a>
			<a href="javascript:search_sku_order(' order by sku.chjshj ');">上架时间</a>
			<a href="javascript:;">评论数</a>
		</dir>
	<hr>
	<dir id="search_inner">
		<%@ include file="sale_search_inner.jsp" %>
	</dir>
	
</body>
</html>