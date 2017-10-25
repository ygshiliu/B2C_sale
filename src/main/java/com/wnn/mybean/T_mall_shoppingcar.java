package com.wnn.mybean;

import java.math.BigDecimal;
import java.util.Date;

public class T_mall_shoppingcar {
	private Integer Id      ;
	private String sku_mch ;
	private double sku_jg  ;
	private int tjshl   ;//添加数据
	private double hj      ;//合计
	private int yh_id   ;
	private int shp_id  ;
	private Date chjshj  ;
	private int sku_id  ;
	private String shp_tp  ;
	private String shfxz   ;//是否选中
	private String kcdz    ;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getSku_mch() {
		return sku_mch;
	}
	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}
	public double getSku_jg() {
		return sku_jg;
	}
	public void setSku_jg(double sku_jg) {
		this.sku_jg = sku_jg;
	}
	public int getTjshl() {
		return tjshl;
	}
	public void setTjshl(int tjshl) {
		this.tjshl = tjshl;
	}
	public double getHj() {
		BigDecimal jg = new BigDecimal(getSku_jg()+"");
		BigDecimal shl = new BigDecimal(getTjshl()+"");
		BigDecimal multiply = jg.multiply(shl);
		
		return multiply.doubleValue();
	}
	public void setHj(double hj) {
		this.hj = hj;
	}
	public int getYh_id() {
		return yh_id;
	}
	public void setYh_id(int yh_id) {
		this.yh_id = yh_id;
	}
	public int getShp_id() {
		return shp_id;
	}
	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	public int getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	public String getShp_tp() {
		return shp_tp;
	}
	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}
	public String getShfxz() {
		return shfxz;
	}
	public void setShfxz(String shfxz) {
		this.shfxz = shfxz;
	}
	public String getKcdz() {
		return kcdz;
	}
	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + shp_id;
		result = prime * result + ((shp_tp == null) ? 0 : shp_tp.hashCode());
		result = prime * result + sku_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	
		T_mall_shoppingcar other = (T_mall_shoppingcar) obj;
		if (shp_id != other.shp_id)
			return false;
		
		if (sku_id != other.sku_id)
			return false;
		
		return true;
	}
	
	
}
