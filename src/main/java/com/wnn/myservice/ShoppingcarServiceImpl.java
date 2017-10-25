package com.wnn.myservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnn.mybean.T_mall_shoppingcar;
import com.wnn.mydao.T_mall_shoppingcar_Mapper;

@Service
public class ShoppingcarServiceImpl implements ShoppingcarServiceInf {
	@Autowired
	private T_mall_shoppingcar_Mapper shoppingcar_Mapper;
	
	@Override
	public void save_T_mall_shoppingcar(T_mall_shoppingcar shoppingcar) {
		shoppingcar_Mapper.insert_T_mall_shoppingcar(shoppingcar);
	}

	@Override
	public void update_shl_and_hj(T_mall_shoppingcar t_mall_shoppingcar) {
		shoppingcar_Mapper.update_shl_and_hj(t_mall_shoppingcar);
		
	}

	@Override
	public List<T_mall_shoppingcar> get_T_mall_shoppingcar_by_user_id(Integer id) {
		return shoppingcar_Mapper.select_T_mall_shoppingcar_by_user_id(id);
	}

	@Override
	public void bantch_T_mall_shoppingcar(List<T_mall_shoppingcar> needList) {
		shoppingcar_Mapper. bantch_T_mall_shoppingcar(needList);
	}

}
