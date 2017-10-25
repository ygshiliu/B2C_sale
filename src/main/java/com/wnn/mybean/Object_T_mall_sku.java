package com.wnn.mybean;

import java.util.List;

public class Object_T_mall_sku extends T_mall_sku{
	private List<T_mall_sku_attr_value> sku_attr_list;
	private T_mall_product t_mall_product;
	private T_mall_trade_mark T_mall_trade_mark;
	private List<T_mall_product_image> product_image_list;
	private List<Object_T_mall_attr> attr_list;
	
	
	public List<T_mall_product_image> getProduct_image_list() {
		return product_image_list;
	}

	public void setProduct_image_list(List<T_mall_product_image> product_image_list) {
		this.product_image_list = product_image_list;
	}

	

	public List<Object_T_mall_attr> getAttr_list() {
		return attr_list;
	}

	public void setAttr_list(List<Object_T_mall_attr> attr_list) {
		this.attr_list = attr_list;
	}

	public List<T_mall_sku_attr_value> getSku_attr_list() {
		return sku_attr_list;
	}

	public void setSku_attr_list(List<T_mall_sku_attr_value> sku_attr_list) {
		this.sku_attr_list = sku_attr_list;
	}

	public T_mall_product getT_mall_product() {
		return t_mall_product;
	}

	public void setT_mall_product(T_mall_product t_mall_product) {
		this.t_mall_product = t_mall_product;
	}

	public T_mall_trade_mark getT_mall_trade_mark() {
		return T_mall_trade_mark;
	}

	public void setT_mall_trade_mark(T_mall_trade_mark t_mall_trade_mark) {
		T_mall_trade_mark = t_mall_trade_mark;
	}
	
	
	 
}
