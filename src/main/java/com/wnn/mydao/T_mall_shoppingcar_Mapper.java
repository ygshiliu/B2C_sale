package com.wnn.mydao;

import java.util.HashMap;
import java.util.List;

import com.wnn.mybean.T_mall_shoppingcar;

public interface T_mall_shoppingcar_Mapper {

	void insert_T_mall_shoppingcar(T_mall_shoppingcar shoppingcar);

	void update_shl_and_hj(T_mall_shoppingcar shoppingcar);

	List<T_mall_shoppingcar> select_T_mall_shoppingcar_by_user_id(Integer yh_id);

	void bantch_T_mall_shoppingcar(List<T_mall_shoppingcar> list);

}
