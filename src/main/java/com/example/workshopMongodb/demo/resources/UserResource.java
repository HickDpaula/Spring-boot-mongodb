package com.example.workshopMongodb.demo.resources;


import com.example.workshopMongodb.demo.dto.UserDTO;
import com.example.workshopMongodb.demo.entities.User;
import com.example.workshopMongodb.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
     List<User> list = userService.findAll();
     List<UserDTO> listDto = list.stream().map(user -> new UserDTO (user)).collect(Collectors.toList());
      return ResponseEntity.ok().body(listDto);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
         User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> Insert(@RequestBody UserDTO objDTO){
        User obj = userService.fromDTO(objDTO);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }
}
