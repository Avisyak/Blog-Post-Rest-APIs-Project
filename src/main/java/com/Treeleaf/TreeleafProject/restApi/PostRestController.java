package com.Treeleaf.TreeleafProject.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Treeleaf.TreeleafProject.Model.Post;
import com.Treeleaf.TreeleafProject.Service.PostService;

@RestController
public class PostRestController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/post/api/list")
	public List<Post>  getAllpost(){
		return postService.getAllPost();
	}
	@PostMapping("/post/api/add")
	public String addPost(@RequestBody Post post) {
		postService.addPost(post);
		return "AddedSuccess";
	}
	@PutMapping("/post/api/update")
	public String updatePost(@RequestBody Post post) {
		postService.updatePost(post);
		return "UpdateSuccess";
	}
	@DeleteMapping("/post/api/delete/{id}")
	public String deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return "Delete Success";
	}
	@GetMapping("/post/api/{id}")
	public Post getOnePost(@PathVariable int id) {
		return postService.getPostById(id);
	}
	

}
