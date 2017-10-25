package com.wnn.mycontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnn.mybean.T_mall_shoppingcar;
import com.wnn.mybean.T_mall_user_account;
import com.wnn.myservice.ShoppingcarServiceInf;
import com.wnn.myutils.MyJsonUtils;

@Controller
public class ShoppingcarController {
	@Autowired
	private ShoppingcarServiceInf shoppingcarService;

	@RequestMapping("sale_cart_success")
	public String sale_cart_success(T_mall_shoppingcar cart) {
		return "sale_cart_success";
	}

	@RequestMapping("add_sku_to_cart")
	public String add_sku_to_cart(
			@CookieValue(value = "cart_list_cookie", required = false) String cart_list_cookie,
			HttpSession session,HttpServletResponse response, T_mall_shoppingcar shoppingcar) {
		
		T_mall_user_account login_user = (T_mall_user_account) session.getAttribute("user");
		
		if(login_user == null){
			//没登录
			if(StringUtils.isBlank(cart_list_cookie)){
				List<T_mall_shoppingcar> cart = new ArrayList<T_mall_shoppingcar>();
				cart.add(shoppingcar);
				cart_list_cookie = MyJsonUtils.getJson(cart);
			}else{
				List<T_mall_shoppingcar> list = MyJsonUtils.toList(cart_list_cookie, T_mall_shoppingcar.class);
				
				//商品是否已经存在
				boolean flag = list.contains(shoppingcar);
				if(flag){
					//已存在
					for (T_mall_shoppingcar t_mall_shoppingcar : list) {
						int sku_id = t_mall_shoppingcar.getSku_id();
						if(sku_id == shoppingcar.getSku_id()){
							int tjshl = t_mall_shoppingcar.getTjshl();
							t_mall_shoppingcar.setTjshl(tjshl+1);
							break;
						}
					}
					cart_list_cookie = MyJsonUtils.getJson(list);
				}else{
					//新数据
					list.add(shoppingcar);
					cart_list_cookie = MyJsonUtils.getJson(list);
				}
				
			}
			
			Cookie cookie = new Cookie("cart_list_cookie", cart_list_cookie);
			response.addCookie(cookie);
		}else{
			//已登录
			List<T_mall_shoppingcar> list= (List<T_mall_shoppingcar>) session.getAttribute("cart_list_session");
			if(list==null || list.size()==0){
				//session中没有购物数据
				//与用户关联
				shoppingcar.setYh_id(login_user.getId());
				//保存到数据库中
				shoppingcarService.save_T_mall_shoppingcar(shoppingcar);
				//同步到session
				List<T_mall_shoppingcar> cart = new ArrayList<T_mall_shoppingcar>();
				cart.add(shoppingcar);
				session.setAttribute("cart_list_session", cart);
			}else{
				//session中有购物数据
				//是否重复
				boolean flag = list.contains(shoppingcar);
				if(flag){
					//有
					for (T_mall_shoppingcar t_mall_shoppingcar : list) {
						int sku_id = t_mall_shoppingcar.getSku_id();
						if(sku_id == shoppingcar.getSku_id()){
							int tjshl = t_mall_shoppingcar.getTjshl()+1;
							t_mall_shoppingcar.setTjshl(tjshl);
							shoppingcarService.update_shl_and_hj(t_mall_shoppingcar);
							break;
						}
					}
				}else{
					//无
					shoppingcar.setYh_id(login_user.getId());
					list.add(shoppingcar);
					shoppingcarService.save_T_mall_shoppingcar(shoppingcar);
				}
				
			}
		}
		
		return "redirect:/sale_cart_success.htm";
	}
	
	@RequestMapping("get_miniCart")
	public String get_miniCart(ModelMap map, HttpSession session,
			@CookieValue(value = "cart_list_cookie", required = false) String cart_list_cookie) {
		T_mall_user_account user = (T_mall_user_account) session.getAttribute("user");
		List<T_mall_shoppingcar> list_cart = new ArrayList<T_mall_shoppingcar>();
		if (user == null) {
			list_cart = MyJsonUtils.toList(cart_list_cookie, T_mall_shoppingcar.class);
		} else {
			list_cart = (List<T_mall_shoppingcar>) session.getAttribute("cart_list_session");
		}
		map.put("list_cart", list_cart);
		return "sale_mini_cart_inner";
	}
	@RequestMapping("goto_cart_list")
	public String goto_cart_list(ModelMap map, HttpSession session,
			@CookieValue(value = "cart_list_cookie", required = false) String cart_list_cookie) {
		T_mall_user_account user = (T_mall_user_account) session.getAttribute("user");
		List<T_mall_shoppingcar> list_cart = new ArrayList<T_mall_shoppingcar>();
		if (user == null) {
			list_cart = MyJsonUtils.toList(cart_list_cookie, T_mall_shoppingcar.class);
		} else {
			list_cart = (List<T_mall_shoppingcar>) session.getAttribute("cart_list_session");
		}
		map.put("list_cart", list_cart);
		return "sale_cart_list";
	}
}
