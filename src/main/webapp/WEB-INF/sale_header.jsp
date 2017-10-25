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
	$(function(){
		var yh_mch = decodeURIComponent(login_yh_mch());
		if(yh_mch != ""){
			$("#mch").text(yh_mch);
		}
	})
	function login_yh_mch(){
		var cookie = document.cookie;
		cookie = cookie.replace(/\s/,"");
		var cookies = cookie.split(";");
		for(var i=0;i<cookies.length;i++){
			var values = cookies[i].split("=");
			if("yh_mch"==values[0]){
				return values[1];
			}
		}
		return "";
	}
	
</script>
</head>
<body>
	<c:if test="${empty user }">
		<span id="mch" style="color:red"></span><a href="${pageContext.request.contextPath }/goto_login.htm">请登录</a>
		&nbsp;&nbsp;
		<a>注册</a> 
	</c:if>
	<c:if test="${not empty user }">
		欢迎${user.yh_nch } &nbsp;&nbsp; 我的订单 &nbsp;&nbsp; <a>退出</a>
	</c:if>
</body>
</html>