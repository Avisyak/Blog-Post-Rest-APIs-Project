package com.Treeleaf.TreeleafProject.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Treeleaf.TreeleafProject.Model.User;
import com.Treeleaf.TreeleafProject.Service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService  userService;
	
	@GetMapping("/user/api/list")
	public List<User> getAllUser(){
		
		return userService.getAllUser();
		
	}

}
