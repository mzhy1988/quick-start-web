package com.comit.report.po;

import com.comit.base.access.BasicPO;
import com.comit.report.dao.UserMapper;

public class User extends BasicPO implements UserMapper{
	protected Integer ad_user_id;
	protected String name;
	
	public Integer getAd_user_id() {
		return ad_user_id;
	}
	public void setAd_user_id(Integer ad_user_id) {
		this.ad_user_id = ad_user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
}
