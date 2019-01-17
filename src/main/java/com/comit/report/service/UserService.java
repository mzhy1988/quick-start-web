package com.comit.report.service;

import java.util.List;

import com.comit.report.po.User;

public interface UserService {
	  public List<User> getUserById(int userId);
}
