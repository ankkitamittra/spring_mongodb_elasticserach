package com.service.db.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.service.db.crud.model.Posts;
import com.service.db.crud.repository.PostsRepository;

@Service
public class PostsService {
	
	 @Autowired
	 PostsRepository postDao;
	 
	 public List <Posts> getAllPosts(){
		List<Posts> posts = new ArrayList<Posts>();
		postDao.findAll().forEach(posts::add);
		return posts; 
	 }
	 
	 public Posts createPost(Posts myPost) {
		 Posts _post = postDao.save(new Posts(myPost.getTitle()));
		 return _post;
	 }
	 

	 public Optional<Posts> getPostById(String id) {
		 Optional<Posts> post = postDao.findById(id);
		 return post;
	 }
	 
	 public Posts updatePost(String id, Posts myPost) {
		 Optional<Posts> posts = postDao.findById(id);
		 if (posts.isPresent()) {
		 	Posts _post = posts.get();
	    	_post.setTitle(myPost.getTitle());
	    	postDao.save(_post);
	    	return _post;
		 }
		    
		return null;
	 }
	 
	 public void deletePost(String id) {
		 postDao.deleteById(id);
	 }
	 
	 public void deleteAllPosts() {
		 postDao.deleteAll();
	 }

}
