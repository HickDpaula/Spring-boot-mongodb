package com.example.workshopMongodb.demo.repository;

import com.example.workshopMongodb.demo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContaining(String text);

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
}
