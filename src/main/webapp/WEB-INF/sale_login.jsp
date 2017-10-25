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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		var cookie_value = get_cookie_value("yh_mch");
		console.log("***"+cookie_value);
		$('[name="yh_mch"]').val(cookie_value);
	})
	
	function get_cookie_value(name){
		//通过document对象获取cookie，返回String类型的cookie值，格式如：yh_mch=haha; testyh=test01
		var cookies = document.cookie;
		//使用JS中的String对象提供的方法替换掉字符串中的空格
		cookies = cookies.replace(/\s/,"");
		//对字符串进行拆分成字符串数组
		var str = cookies.split(";");
		var cookie_value = "";
		//遍历字符串数组
		for(var i=0;i<str.length;i++){
			var temp = str[i]; //返回 yh_mch=haha，继续拆分
			var val = temp.split("=");
			var cookie_name = val[0];
			if(cookie_name == name){
				cookie_value = val[1];
				break;
			}
		}
		return cookie_value;
	}
	function to_submit(){
		$("#login_form").submit();
	}
</script>
</head>
<body>
	<div class="up">
			<img src="images/logo.jpg" height="45px;" class="hy_img"/>
			<div class="hy">
				欢迎登录
			</div>
		</div>
		<div class="middle">
			<div class="login">
				<div class="l1 ">
					<div class="l1_font_01 ">硅谷会员</div>
					<a class="l1_font_02 " href="<%=application.getContextPath() %>/to_regist.action">用户注册</a>
				</div>
				<div class="blank_01"></div>
				<div class="ts">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${err}
				</div>
				<div class="blank_01"></div>
				<form action="login.do" id="login_form" method="post">
					<div class="input1">
						<input type="text" class="input1_01" name="yh_mch"/>
					</div>
					<div class="blank_01"></div>
					<div class="blank_01"></div>
					<div class="input2">
						<input type="text" class="input1_01" name="yh_mm"/>
					</div>
				
				<div class="blank_01"></div>
				<div class="blank_01"></div>
				<div class="box_01">
					<div class="box_01_both_1">
  							<input type="radio" name = "user_type" value="user"/>系统用户
  							<input type="radio" name = "user_type" value="tester"/>测试用户
  					</div>
					<!-- <input type="checkbox" class="box_01_box"/>
					<div class="box_01_both">
						<div class="box_01_both_1">自动登陆</div>
						<div class="box_01_both_2">忘记密码？</div>
					</div> -->
				</div>
				</form>
				<div class="blank_01"></div>
				<a href="javascript:;" class="aline">
					<div class="red_button" onclick="to_submit()">
						登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
					</div>
				</a>
				<div class="blank_01"></div>
				<div class="blank_01"></div>
				<div class="box_down">
					<div class="box_down_1">使用合作网站账号登录京东：</div>
					<div class="box_down_1">京东钱包&nbsp;&nbsp;|&nbsp;&nbsp;QQ 
					&nbsp;&nbsp;|&nbsp;&nbsp;微信
					</div>
				</div>
			</div>	
		</div>
		
		<div class="down">
			<br />
			Copyright©2004-2015  xu.jb.com 版权所有
		</div>
</body>
</html>