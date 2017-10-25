package com.wnn.mydao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wnn.mybean.Object_T_mall_attr;
import com.wnn.mybean.T_mall_value;

public interface Attr_Mapper {

	List<Object_T_mall_attr> select_attr_by_class_2(Integer flbh2_id);

	void insert_attr(Object_T_mall_attr attr);

	void insert_value(@Param("id")Integer id,@Param("list_value") List<T_mall_value> list_value);

}
