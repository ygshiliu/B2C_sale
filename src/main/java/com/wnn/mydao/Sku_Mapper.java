package com.wnn.mydao;

import java.util.HashMap;

import com.wnn.mybean.Object_T_mall_sku;

public interface Sku_Mapper {

	void insert_sku(Object_T_mall_sku sku_bean);

	void insert_sku_attr(HashMap<String, Object> map);

}
