package com.comit.base.access;

import java.util.List;

import com.comit.report.po.User;

public interface BaseMapper {
	//����ɾ�����������
	public void save(BasicPO po);
	public void delete(BasicPO po);
	public Object getPO(Object primaryKey);
	public List<User> getObjects();//���� ���ݿ��ȡ���е� ��¼ ������
}
