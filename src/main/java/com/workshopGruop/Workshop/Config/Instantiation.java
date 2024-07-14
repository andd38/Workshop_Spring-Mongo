package com.workshopGruop.Workshop.Config;

import com.workshopGruop.Workshop.domain.Entities.User;
import com.workshopGruop.Workshop.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(null, "maria", "maria@21gmail.com");
        User user2 = new User(null, "joao", "joao@21gmail.com");
        User user3 = new User(null, "ana", "ana@21gmail.com");

        userRepository.saveAll(Arrays.asList(user2,user1,user3));

    }
}
