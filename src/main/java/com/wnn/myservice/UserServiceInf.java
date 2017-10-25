package com.wnn.myservice;

import javax.jws.WebService;

import com.wnn.mybean.T_mall_user_account;
@WebService
public interface UserServiceInf {

	public T_mall_user_account login(T_mall_user_account user);
	public T_mall_user_account test_login(T_mall_user_account user);
	public boolean regist(T_mall_user_account user);

}
