package com.workshopGruop.Workshop.Config;

import com.workshopGruop.Workshop.domain.Entities.Post;
import com.workshopGruop.Workshop.domain.Entities.User;
import com.workshopGruop.Workshop.domain.repository.PostRepository;
import com.workshopGruop.Workshop.domain.repository.UserRepository;
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
        postRepository.deleteAll();
        User user1 = new User(null, "maria", "maria@21gmail.com");
        User user2 = new User(null, "joao", "joao@21gmail.com");
        User user3 = new User(null, "ana", "ana@21gmail.com");

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"partiu viagem","Vou viajar para sao paulo",user1);
        Post post2 = new Post(null,sdf.parse("21/03/2018"),"partiu viagem","Vou viajar para bahia",user1);
        Post post3 = new Post(null,sdf.parse("25/07/2022"),"partiu viagem","Vou viajar para goias",user2);

        postRepository.saveAll(Arrays.asList(post1,post2,post3));
        userRepository.saveAll(Arrays.asList(user2,user1,user3));



    }
}
