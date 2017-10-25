package com.wnn.myservice;

import java.util.List;

import com.wnn.mybean.T_mall_shoppingcar;

public interface ShoppingcarServiceInf {

	void save_T_mall_shoppingcar(T_mall_shoppingcar shoppingcar);

	void update_shl_and_hj(T_mall_shoppingcar t_mall_shoppingcar);

	List<T_mall_shoppingcar> get_T_mall_shoppingcar_by_user_id(Integer id);

	void bantch_T_mall_shoppingcar(List<T_mall_shoppingcar> needList);

}
