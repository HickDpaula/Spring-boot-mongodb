package com.example.workshopMongodb.demo.repository;

import com.example.workshopMongodb.demo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
