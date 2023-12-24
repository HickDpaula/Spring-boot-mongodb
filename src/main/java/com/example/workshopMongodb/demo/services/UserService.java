package com.example.workshopMongodb.demo.services;

import com.example.workshopMongodb.demo.entities.User;
import com.example.workshopMongodb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){

        return userRepository.findAll();

    }
}
