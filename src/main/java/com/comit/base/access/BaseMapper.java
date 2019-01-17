package com.comit.base.access;

import java.util.List;

import com.comit.report.po.User;

public interface BaseMapper {
	//增、删、查基本方法
	public void save(BasicPO po);
	public void delete(BasicPO po);
	public Object getPO(Object primaryKey);
	public List<User> getObjects();//测试 数据库获取所有的 记录 方法；
}
