package com.wnn.mydao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wnn.mybean.T_mall_class_2;
import com.wnn.mybean.T_mall_product;


public interface Spu_Mapper {

	public void save_spu(T_mall_product t_mall_product);

	public void save_spu_img(@Param("id")Integer id,@Param("list_img") List<String> list_img);

	public List<T_mall_product> select_sku_spu_by_tm(Map<String,Object> map);
}
