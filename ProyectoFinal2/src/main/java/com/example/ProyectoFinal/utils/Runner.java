package com.example.ProyectoFinal.utils;

import com.example.ProyectoFinal.model.Authority;
import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.repository.AuthorityRepository;
import com.example.ProyectoFinal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.authorityRepository.count() == 0)
        {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.USER)
            ));
        }

        if(this.userRepository.count() == 0)
        {
            this.userRepository.saveAll(List.of(
                    new UserEntity(1l,"luis", "lopez", "l@l", "123", "1/1/1", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new UserEntity(2l,"aa", "aa", "a@a", "123", "1/1/1", List.of(this.authorityRepository.findByName(AuthorityName.USER).get())),
                    new UserEntity(3l,"bb", "bb", "b@b", "123", "1/1/1", List.of(this.authorityRepository.findByName(AuthorityName.USER).get()))
            ));
        }

    }
}
