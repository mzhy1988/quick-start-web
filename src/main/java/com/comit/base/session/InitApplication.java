package com.comit.base.session;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InitApplication implements  ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SessionFactory.init(applicationContext.getBean(org.mybatis.spring.SqlSessionFactoryBean.class));
	}
}
