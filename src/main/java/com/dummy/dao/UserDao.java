package com.dummy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.controller.UserController;
import com.dummy.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

}
