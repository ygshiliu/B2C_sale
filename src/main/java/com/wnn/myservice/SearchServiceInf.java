package com.wnn.myservice;

import java.util.List;

import com.wnn.mybean.Model_T_mall_sku_attr_value;
import com.wnn.mybean.Object_T_mall_attr;
import com.wnn.mybean.Object_T_mall_sku;
import com.wnn.mybean.T_mall_sku;

public interface SearchServiceInf {
	
	public List<Object_T_mall_sku> get_sku_by_class_2(Integer class_2_id);

	public List<Object_T_mall_attr> get_attr_by_class_2(Integer class_2_id);

	public List<Object_T_mall_sku> get_sku_by_attr(Integer class_2_id,
			Model_T_mall_sku_attr_value list_attr_value, String order);
	
	public Object_T_mall_sku get_sku_by_id(Integer sku_id);
	
	public List<T_mall_sku> get_sku_by_spu_id(Integer shp_id);
}
