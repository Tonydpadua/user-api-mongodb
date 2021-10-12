package com.tony.apimongodb.config;

import com.tony.apimongodb.post.dto.AuthorDTO;
import com.tony.apimongodb.post.Post;
import com.tony.apimongodb.post.PostRepository;
import com.tony.apimongodb.post.dto.CommentDTO;
import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@RequiredArgsConstructor
public class DbService implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        this.userRepository.deleteAll();
        this.postRepository.deleteAll();

        User marieUser = new User(null, "Marie", "marie@email.com");
        User bobUser = new User(null, "Bob", "bob@email.com");
        User alexUser = new User(null, "Alex", "alex@email.com");

        this.userRepository.saveAll(Arrays.asList(marieUser, bobUser, alexUser));

        CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2021"), AuthorDTO.from(alexUser));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("21/03/2021"), AuthorDTO.from(bobUser));
        CommentDTO c3 = new CommentDTO("Tenha um bom dia", sdf.parse("21/03/2021"), AuthorDTO.from(alexUser));

        Post post1 = new Post(null, sdf.parse("21/09/2021"), "Viajar",
                "Viando para Argentina", AuthorDTO.from(marieUser), Arrays.asList(c1, c2));
        Post post2 = new Post(null, sdf.parse("23/09/2021"), "Bom dia",
                "Tomando café", AuthorDTO.from(marieUser), Arrays.asList(c3));

        this.postRepository.saveAll(Arrays.asList(post1, post2));

        marieUser.getPosts().addAll(Arrays.asList(post1, post2));

        this.userRepository.save(marieUser);
    }
}
