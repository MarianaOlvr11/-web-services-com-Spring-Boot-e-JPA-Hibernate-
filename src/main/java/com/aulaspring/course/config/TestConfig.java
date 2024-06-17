package com.aulaspring.course.config;


import com.aulaspring.course.entities.User;
import com.aulaspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // serve para popular o banco de dados com objetos

    @Autowired
    private UserRepository userRepository; // injeta dependencia


    @Override
    public void run(String... args) throws Exception { // tudo dentro desse metodo sera instanciado quando a operação rodar

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); // salva uma lista com os dois objetos

    }
}
