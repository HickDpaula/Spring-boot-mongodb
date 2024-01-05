package com.example.workshopMongodb.demo.services;

import com.example.workshopMongodb.demo.entities.Post;
import com.example.workshopMongodb.demo.entities.User;
import com.example.workshopMongodb.demo.repository.PostRepository;
import com.example.workshopMongodb.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
