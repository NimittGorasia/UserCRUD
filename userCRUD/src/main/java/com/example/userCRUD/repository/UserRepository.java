package com.example.userCRUD.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.userCRUD.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private List<User> listOfUsers;
	
	private static int id = 1;
	
	public User fetchUser(String userName) {
		User reqUser = null;
		for(User user : listOfUsers) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				reqUser =  user;
			}
		}
		return reqUser;
	}
	
	public void addUser(User user) {
		listOfUsers.add(new User(id++,user.getUserName(),user.getEmailId()));
	}
	
	public List<User> fetchAllUser() {
		return listOfUsers;
	}
	
	
	public String updateUserName(String userName, User updatedUser) {
		String status = null;
		for(User user : listOfUsers) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				
				if(!updatedUser.getUserName().equalsIgnoreCase(user.getUserName())) {
					user.setUserName(updatedUser.getUserName());
				}
				if(!updatedUser.getEmailId().equalsIgnoreCase(user.getEmailId())) {
					user.setEmailId(updatedUser.getEmailId());
				}
				status = "User Updated Successfully";
				break;
			}
			else {
				status = "Please check that this user is added";
			}
		}
		return status;
	}
	
	public String deleteUser(String userName) {
		String status = null;
		User reqUser = null;
		for(User user : listOfUsers) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				reqUser = user;
				status = "User deleted Successfully";
			}
			else {
				status = "Unable to perform deletion operation";
			}
		}
		
		listOfUsers.remove(reqUser);
		return status;
	}
}
