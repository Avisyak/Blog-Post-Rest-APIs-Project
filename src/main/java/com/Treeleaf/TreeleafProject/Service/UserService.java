package com.Treeleaf.TreeleafProject.Service;

import java.util.List;

import com.Treeleaf.TreeleafProject.Model.User;

public interface UserService {
	
	void usersignup(User user);
	User userLogin(String un,String psw);
	List<User> getAllUser(); 

}
