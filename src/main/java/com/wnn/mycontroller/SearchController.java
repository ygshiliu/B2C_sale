package com.wnn.mycontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnn.mybean.Model_T_mall_sku_attr_value;
import com.wnn.mybean.Object_T_mall_attr;
import com.wnn.mybean.Object_T_mall_sku;
import com.wnn.mybean.T_mall_sku;
import com.wnn.myservice.SearchServiceInf;

@Controller
public class SearchController {
	@Autowired
	private SearchServiceInf searchService;
	
	@RequestMapping("get_sku_by_id")
	public String get_sku_by_id(Integer sku_id,Integer spu_id,Map<String,Object> map){
		Object_T_mall_sku sku_detail = searchService.get_sku_by_id(sku_id);
		List<T_mall_sku> sku_list = searchService.get_sku_by_spu_id(spu_id);
		map.put("sku_list", sku_list);
		map.put("sku_detail", sku_detail);
		return "sale_search_sku_detail";
	}
	
	@RequestMapping("get_sku_by_attr")
	public String get_sku_by_attr(Integer class_2_id,Model_T_mall_sku_attr_value list_attr_value,String order,Map<String,Object> map){
		List<Object_T_mall_sku> sku_list = searchService.get_sku_by_attr(class_2_id,list_attr_value,order);
		map.put("sku_list", sku_list);
		map.put("class_2_id", class_2_id);
		return "sale_search_inner";
	}
	
	@RequestMapping("goto_spu_by_class_2")
	public String goto_spu_by_class_2(Integer class_2_id,String class_2_name,Map<String,Object> map){
		List<Object_T_mall_attr> attrList = searchService.get_attr_by_class_2(class_2_id);
		List<Object_T_mall_sku> sku_list = searchService.get_sku_by_class_2(class_2_id);
		map.put("attrList", attrList);
		map.put("sku_list", sku_list);
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		return "sale_search";
	}

}
