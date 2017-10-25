package com.wnn.mybean;

import java.util.Date;

public class T_mall_value {
	
	
	private Integer Id;
	private String shxzh;
	private String shfqy;
	private int shxm_id;
	//单位
	private String shxzh_mch;
	private Date chjshj;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getShxzh() {
		return shxzh;
	}
	public void setShxzh(String shxzh) {
		this.shxzh = shxzh;
	}
	public String getShfqy() {
		return shfqy;
	}
	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}
	public int getShxm_id() {
		return shxm_id;
	}
	public void setShxm_id(int shxm_id) {
		this.shxm_id = shxm_id;
	}
	public String getShxzh_mch() {
		return shxzh_mch;
	}
	public void setShxzh_mch(String shxzh_mch) {
		this.shxzh_mch = shxzh_mch;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	
}
