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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css">
<link rel="shortcut icon" type="image/icon" href="${pageContext.request.contextPath }/images/jd.ico">
<title>硅谷商城</title>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("${pageContext.request.contextPath}/js/json/class_1.js",function(data){
			$(data).each(function(){
				$("#class_1_ul").append("<li onmouseover='show_class_2_by_class_1(this.id)' id='"+this.id+"'>"+this.flmch1+"</li>");
			})
		})

	})
	
	function show_class_2_by_class_1(class_1_id){
			$("#class_2_ul").empty();
			$.getJSON("${pageContext.request.contextPath}/js/json/class_2_"+class_1_id+".js",function(data){
				$(data).each(function(){
					$("#class_2_ul").append("<li><a href='goto_spu_by_class_2.do?class_2_id="+this.id+"&class_2_name="+this.flmch2+"'>"+this.flmch2+"</a></li>");
				})
			})
			$("#class_2_ul").show();
		}
	
		
</script>
</head>
<body>
	<jsp:include page="sale_header.jsp"></jsp:include>
	<div class="top_img">
		<img src="images/top_img.jpg" alt="">
	</div>
	
	<div class="search">
		<div class="logo"><img src="./images/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
		<jsp:include page="sale_mini_cart.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini">
						<ul  id="class_1_ul">
							<li>
								<a href="">家用电器</a>
								<div class="two_nav" id="class_2_ul">
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
									<a href="">11111</a>
								</div>
							</li>
							<li><a href="">营养保健</a></li>
							<li><a href="">图书</a></li>
							<li><a href="">彩票</a></li>
							<li><a href="">理财</a></li>
						</ul>
					</div>
				</div>
				<ul>
					<li><a href="">服装城</a></li>
					<li><a href="">美妆馆</a></li>
					<li><a href="">超市</a></li>
					<li><a href="">全球购</a></li>
					<li><a href="">闪购</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">拍卖</a></li>
					<li><a href="">金融</a></li>
					<li><a href="">智能</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="banner">
		<div class="ban">
			<img src="images/banner.jpg" width="980" height="380" alt="">
		</div>
	</div>
	
	<hr>
	<ul id="class_1_ul" style="width:70px;"></ul>
	<ul id="class_2_ul"></ul>
</body>
</html>