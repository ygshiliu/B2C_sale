package com.wnn.mydao;

import java.util.HashMap;
import java.util.List;

import com.wnn.mybean.Object_T_mall_sku;
import com.wnn.mybean.T_mall_sku;

public interface Search_Mapper {
	
	public List<Object_T_mall_sku> select_sku_by_class_2(Integer class_2_id);

	public List<Object_T_mall_sku> select_sku_by_attr(
			HashMap<String, Object> map);
	
	public Object_T_mall_sku select_sku_by_id(Integer sku_id);
	
	public List<T_mall_sku> select_sku_by_spu_id(Integer shp_id);
}
