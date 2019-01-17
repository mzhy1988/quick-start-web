package com.comit.report.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comit.report.dao.UserMapper;
import com.comit.report.po.User;
import com.comit.report.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userDao;
	public List<User> getUserById(int userId) {
		return this.userDao.getObjects();
	}
}
