package com.Treeleaf.TreeleafProject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Treeleaf.TreeleafProject.Model.User;
import com.Treeleaf.TreeleafProject.Repository.UserRepositoy;
import com.Treeleaf.TreeleafProject.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositoy userRepo;

	@Override
	public void usersignup(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String un, String psw) {
		return userRepo.findByUsernameAndPassword(un, psw);
		
	}

	@Override
	public List<User> getAllUser() {
	
		return userRepo.findAll();
	}

}
