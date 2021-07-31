package com.example.userCRUD.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userCRUD.model.User;
import com.example.userCRUD.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user){ 
		userRepository.addUser(user);
		return "User added successfully";
	}
	
	@GetMapping("/fetchUser/{userName}")
	public User fetchUser(@PathVariable String userName){ 
		return userRepository.fetchUser(userName);
	}
	
	@GetMapping("/fetchAllUser")
	public List<User> fetchAllUser(){ 
		return userRepository.fetchAllUser();
	}
	
	@PutMapping("/updateUser/{userName}")
	public String updateUser(@PathVariable String userName,@RequestBody User user){ 
		return userRepository.updateUserName(userName,user);
	}
	
	@DeleteMapping("/deleteUser/{userName}")
	public String deleteUser(@PathVariable String userName){ 
		return userRepository.deleteUser(userName);
	}
}
