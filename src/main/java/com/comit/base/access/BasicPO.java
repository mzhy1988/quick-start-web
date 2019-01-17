package com.comit.base.access;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.comit.base.session.SessionFactory;
import com.comit.report.po.User;

public class BasicPO {
	public Class mapperClass;
	public Class getMapperClass() {
		Class<?> interfaces[] = this.getClass().getSuperclass().getInterfaces();
		//�����ʵ�ֵ����нӿ�
		for (Class<?> inte : interfaces) {//��ӡ
			if (BaseMapper.class.isAssignableFrom(inte)&& !inte.getName().equals( BaseMapper.class.getName())) {
				return inte;
			}
		}
		return mapperClass;
	}
	public void setMapperClass(Class mapperClass) {
		this.mapperClass = mapperClass;
	}

	public List<User> getObjects(){return null;}
	public Object getPO(Object primaryKey){
		return getPO(this.getClass(),primaryKey);
	}
	public <T> T getPO(Class T,Object primaryKey){
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionFactory.getSqlSession();
			//����.isAssignableFrom(����)
			if (BaseMapper.class.isAssignableFrom(this.getClass())) {
				BaseMapper maper = (BaseMapper)sqlSession.getMapper(getMapperClass());
				//����������ѯ
				return (T)maper.getPO(124);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)
				SessionFactory.closeSqlSession();
		}
		return null;
	}
	public void beforeSave(){};
	public void afterSave(){};
	public void save(BasicPO po){save();}
	public void save(){
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionFactory.getSqlSession();
			//����.isAssignableFrom(����)
			if (BaseMapper.class.isAssignableFrom(this.getClass())) {
				BaseMapper maper = (BaseMapper)sqlSession.getMapper(getMapperClass());
				maper.save(this);
				List<User>ls =maper.getObjects();
				for (int i = 0; i < ls.size(); i++) {
					System.out.println("==============="+ls.get(i).getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)
				SessionFactory.closeSqlSession();
		}
	}
	public void beforeDelete(){};
	public void afterSDelete(){};
	public void delete(BasicPO po){delete();}
	public void delete(){
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionFactory.getSqlSession();
			BaseMapper maper = (BaseMapper)sqlSession.getMapper(getMapperClass());
			List<User>ls =maper.getObjects();
			for (int i = 0; i < ls.size(); i++) {
				System.out.println("==============="+ls.get(i).getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)
				sqlSession.close();
		}
	}
}
