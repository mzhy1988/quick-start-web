package com.comit.base.session;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;

public class SessionFactory {
	private static ThreadLocal<SqlSession> threadLcoal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactoryBean  sessionFactory= null;
	public static SqlSession getSqlSession() throws Exception{
		SqlSession sqlSession = threadLcoal.get();
		if(sqlSession == null){
			if(sessionFactory!=null){
				sqlSession = sessionFactory.getObject().openSession();
				//将sqlSession与当前线程绑定
				threadLcoal.set(sqlSession);
			}else{
				throw new Exception("未初始化SqlSessionFactory");
			}
		}
		return sqlSession;
	}
	public static void init(SqlSessionFactoryBean factory){
		if(sessionFactory == null){
			sessionFactory  = factory;
		}
	}
	public static void closeSqlSession(SqlSession sqlSession ){
		//SqlSession sqlSession = threadLcoal.get();
		if(sqlSession != null ){
			sqlSession.close();
			threadLcoal.remove();
		}
	}
	public static void closeSqlSession(){
		SqlSession sqlSession = threadLcoal.get();
		if(sqlSession != null){
			sqlSession.close();
			threadLcoal.remove();
		}
	}
	public static <T> T getMapper(Class T) throws Exception{
		return (T)SessionFactory.getSqlSession().getMapper(T);
	}
}
