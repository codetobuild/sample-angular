package com.dummy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.controller.UserController;
import com.dummy.dao.UserDao;
import com.dummy.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User saveUser(User data) {
		return this.userDao.save(data);
	}

	public List<User> getUsers() {
		return this.userDao.findAll();
	}

	public void deleteUser(Long id) {
		this.userDao.deleteById(id);
	}

}
