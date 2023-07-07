package com.Treeleaf.TreeleafProject.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Treeleaf.TreeleafProject.Model.Post;
import com.Treeleaf.TreeleafProject.Service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/addpost")
	public String getpost(HttpSession session) {
		   if(session.getAttribute("activeuser") ==null) { 
				 
				 
				 return "UserLogin"; 
				 
			 }
		return "AddPost";
	}
	@PostMapping("/addpost")
	public String addPost(@ModelAttribute Post post,@RequestParam MultipartFile image,Model model) {
		if(!image.isEmpty()) {
    		try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/Image/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		post.setPhoto(image.getOriginalFilename());
		postService.addPost(post);
		model.addAttribute("message", "New Post Added");
		return "redirect:/addpost";
	}
	@GetMapping("/deletepost")
	public String deletePost(@RequestParam int id) {
		postService.deletePost(id);
		return "redirect:/home";
	}
	@GetMapping("/editpost")
	public String editPost(@RequestParam int id,Model model) {
		
		model.addAttribute("postmodel",postService.getPostById(id));
		return "editpost";
	}
	@PostMapping("/updatepost")
	public String updatepost(@ModelAttribute Post post,Model model) {
		postService.addPost(post);
		return "redirect:/home";
	}

}
