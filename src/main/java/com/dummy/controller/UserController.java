package com.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.entity.Message;
import com.dummy.entity.User;
import com.dummy.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		User savedUser = this.userService.saveUser(user);
		return savedUser;
	}

	@DeleteMapping(value = "/delete/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable(name = "userId") String userId) {
		Long id = Long.parseLong(userId);
		this.userService.deleteUser(id);
		return new String("SUCCESS");
	}

}
