package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.repository.UserRepository;
import com.example.ProyectoFinal.security.SecurityUser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        var optUser = this.userRepository.findByUsername(username);

        if(optUser.isPresent())
        {
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("Username not found: "+username);
    }

    public List<UserEntity> listarUsuarios()
    {
        return userRepository.findAll();
    }
}
