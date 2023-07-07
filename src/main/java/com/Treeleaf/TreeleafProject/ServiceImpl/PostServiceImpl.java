package com.Treeleaf.TreeleafProject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Treeleaf.TreeleafProject.Model.Post;
import com.Treeleaf.TreeleafProject.Repository.PostRepository;
import com.Treeleaf.TreeleafProject.Service.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
	private PostRepository postRepo; 
	
	
	@Override
	public void addPost(Post post) {
		postRepo.save(post);
		
	}

	@Override
	public void deletePost(int id) {
		
		postRepo.deleteById(id);
	}

	@Override
	public void updatePost(Post post) {
		
		postRepo.save(post);
	}

	@Override
	public Post getPostById(int id) {
		
		return postRepo.findById(id).get();
	}

	@Override
	public List<Post> getAllPost() {
		
		return postRepo.findAll();
	}

	
}
