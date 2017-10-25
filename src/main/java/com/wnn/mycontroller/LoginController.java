package com.wnn.mycontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnn.mybean.T_mall_shoppingcar;
import com.wnn.mybean.T_mall_user_account;
import com.wnn.myservice.ShoppingcarServiceInf;
import com.wnn.myservice.UserServiceInf;
import com.wnn.myutils.MyJsonUtils;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceInf userService;
	
	@Autowired
	private ShoppingcarServiceInf shoppingcarService;
	
	@RequestMapping("goto_login")
	public String goto_login(){
		return "sale_login";
	}
	@RequestMapping("login")
	public String login(String user_type,@CookieValue(value="cart_list_cookie",required=false)String cart_list_cookie,T_mall_user_account user,HttpSession session,
			HttpServletRequest request,HttpServletResponse response){
		
		T_mall_user_account login_user =null;
		
		if("user".equals(user_type)){
			login_user = userService.login(user);
		}else{
			login_user = userService.test_login(user);
		}
		 
		
		if(login_user != null){
			
			session.setAttribute("user", login_user);
			
			Cookie cookie = new Cookie("yh_mch", login_user.getYh_mch());
			cookie.setMaxAge(60*60);
			cookie.setPath(request.getContextPath());
			
			/*Cookie cookie1 = new Cookie("testyh", "test01");
			cookie.setMaxAge(60*60);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie1);*/
			
			response.addCookie(cookie);
			
			//用户登录成功后对购物商品进行合并处理
			//根据当前用户id获取db中的数据
			List<T_mall_shoppingcar> dbList = shoppingcarService.get_T_mall_shoppingcar_by_user_id(login_user.getId());
			if(dbList == null){
				//数据库中没有商品
				if(cart_list_cookie==null){
					//ok
				}else{
					//获取cookie中的数据
					List<T_mall_shoppingcar> list = MyJsonUtils.toList(cart_list_cookie, T_mall_shoppingcar.class);
					for (T_mall_shoppingcar t_mall_shoppingcar : list) {
						t_mall_shoppingcar.setYh_id(login_user.getId());
						shoppingcarService.save_T_mall_shoppingcar(t_mall_shoppingcar);
					}
					List<T_mall_shoppingcar> list1 = shoppingcarService.get_T_mall_shoppingcar_by_user_id(login_user.getId());
					session.setAttribute("cart_list_session", list1);
				}
			}else{
				
				if(cart_list_cookie==null){
					session.setAttribute("cart_list_session", dbList);
				}else{
					//数据库中有商品
					//转成Map<Sku_id,T_mall_shoppingcar>
					HashMap<Integer, T_mall_shoppingcar> map = new HashMap<Integer,T_mall_shoppingcar>();
					for (T_mall_shoppingcar t_mall_shoppingcar : dbList) {
						map.put(t_mall_shoppingcar.getSku_id(), t_mall_shoppingcar);
					}
					
					//获取cookie中的数据
					List<T_mall_shoppingcar> list = MyJsonUtils.toList(cart_list_cookie, T_mall_shoppingcar.class);
					
					//比对是否存在 ,或
					for (T_mall_shoppingcar t_mall_shoppingcar : list) {
						t_mall_shoppingcar.setYh_id(login_user.getId());
						boolean flag = dbList.contains(t_mall_shoppingcar);
						if(flag){
							//重复
							int sku_id = t_mall_shoppingcar.getSku_id();
							int tjshl = t_mall_shoppingcar.getTjshl();
							T_mall_shoppingcar shoppingcar = map.get(sku_id);
							shoppingcar.setTjshl(shoppingcar.getTjshl()+tjshl);
							shoppingcarService.update_shl_and_hj(shoppingcar);
							
						}else{
							//新的
							shoppingcarService.save_T_mall_shoppingcar(t_mall_shoppingcar);
						}
					}
					
					//删除cookie
					Cookie cookie2 = new Cookie("cart_list_cookie", "");
					cookie2.setMaxAge(0);
					response.addCookie(cookie2);
					
					//重新查一遍数据库，放入session
					List<T_mall_shoppingcar> dbList2 = shoppingcarService.get_T_mall_shoppingcar_by_user_id(login_user.getId());
					session.setAttribute("cart_list_session", dbList2);
				}
			}
			
		}
		return "sale_index";
	}

}
