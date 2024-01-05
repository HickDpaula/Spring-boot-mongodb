package com.example.workshopMongodb.demo.config;

import com.example.workshopMongodb.demo.dto.AuthorDTO;
import com.example.workshopMongodb.demo.dto.CommentDTO;
import com.example.workshopMongodb.demo.entities.Post;
import com.example.workshopMongodb.demo.entities.User;
import com.example.workshopMongodb.demo.repository.PostRepository;
import com.example.workshopMongodb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();;

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("04/01/2024"),"Partiu viagem", "vou viajar para são paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("05/01/2024"),"Bom dia!", "Acordei feliz!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/18"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/18"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/18"), new AuthorDTO(alex));

                post1.getCommentDTO().addAll(Arrays.asList(c1, c2));
                post2.getCommentDTO().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);


    }
}
