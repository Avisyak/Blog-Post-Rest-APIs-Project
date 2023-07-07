package com.Treeleaf.TreeleafProject.Service;

import java.util.List;

import com.Treeleaf.TreeleafProject.Model.Post;

public interface PostService {
	
	void addPost(Post post);
	void deletePost(int id);
	void updatePost(Post post);
	Post getPostById(int id);
	List<Post> getAllPost();
	
	

}
