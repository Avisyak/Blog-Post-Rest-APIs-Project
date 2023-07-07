package com.Treeleaf.TreeleafProject.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Treeleaf.TreeleafProject.Model.User;
import com.Treeleaf.TreeleafProject.Service.PostService;
import com.Treeleaf.TreeleafProject.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private PostService postservice;
	
	@GetMapping("/login")
	public String getLogin() {
		return "UserLogin";
	}
	
	@GetMapping("/")
	public String gethome2() {
		return "Home2";
	}
	
	@GetMapping("/home")
	public String getHome(HttpSession session,Model model) {

		 if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
				model.addAttribute("plist",postservice.getAllPost());
				return "Home";
			
	}
	

	@GetMapping("/signup")
	public String getSignup() {
		return "UserSignup";
	}
	
	@PostMapping("/signup")
	public String usersignup(@ModelAttribute User user) {
		userservice.usersignup(user);
		return "UserSignup";
	}
	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user,Model model,HttpSession session) {
		User usr=userservice.userLogin(user.getUsername(),user.getPassword());
		if(usr!=null) {
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(20000);
			model.addAttribute("message",usr.getFname());
			return "Home";
		}
		model.addAttribute("error","User not Found");
		return "UserLogin";
	}
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();;
		return "UserLogin";
	}
	
	

}
