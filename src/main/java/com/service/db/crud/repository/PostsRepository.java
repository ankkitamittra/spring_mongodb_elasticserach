package com.service.db.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.db.crud.model.Posts;

public interface PostsRepository extends MongoRepository<Posts, String>{
}
