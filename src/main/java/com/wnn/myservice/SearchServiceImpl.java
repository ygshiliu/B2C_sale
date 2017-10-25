package com.wnn.myservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnn.mybean.Model_T_mall_sku_attr_value;
import com.wnn.mybean.Object_T_mall_attr;
import com.wnn.mybean.Object_T_mall_sku;
import com.wnn.mybean.T_mall_sku;
import com.wnn.mybean.T_mall_sku_attr_value;
import com.wnn.mydao.Attr_Mapper;
import com.wnn.mydao.Search_Mapper;
@Service
public class SearchServiceImpl implements SearchServiceInf {
	@Autowired
	private Search_Mapper search_Mapper;
	@Autowired
	private Attr_Mapper attr_Mapper;
	
	@Override
	public List<Object_T_mall_sku> get_sku_by_class_2(Integer class_2_id) {
		return search_Mapper.select_sku_by_class_2(class_2_id);
	}
	@Override
	public List<Object_T_mall_attr> get_attr_by_class_2(Integer class_2_id) {
		return attr_Mapper.select_attr_by_class_2(class_2_id);
	}
	@Override
	public List<Object_T_mall_sku> get_sku_by_attr(Integer class_2_id,
			Model_T_mall_sku_attr_value list_attr_value, String order) {
		/*StringBuilder builder = new StringBuilder();
		//TODO
		//....
		String sql = builder.toString();*/
		
		List<T_mall_sku_attr_value> list_av = list_attr_value.getList_attr_value();
		ArrayList<Integer> list_av_and = new ArrayList<Integer>();
		if(list_av.size()>1){
			for(int i=0;i<list_av.size()-1;i++){
				list_av_and.add(i+1);
			}
		}
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("class_2_id", class_2_id);
		map.put("list_av", list_av);
		map.put("order", order);
		map.put("list_av_and", list_av_and);
		List<Object_T_mall_sku> list = search_Mapper.select_sku_by_attr(map);
		return list;
	}
	@Override
	public Object_T_mall_sku get_sku_by_id(Integer sku_id) {
		return search_Mapper.select_sku_by_id(sku_id);
	}
	@Override
	public List<T_mall_sku> get_sku_by_spu_id(Integer shp_id) {
		return search_Mapper.select_sku_by_spu_id(shp_id);
	}

}
