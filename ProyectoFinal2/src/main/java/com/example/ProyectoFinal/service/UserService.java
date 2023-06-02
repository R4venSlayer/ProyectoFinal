package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService {
    public List<UserEntity> listAllUsers();
}
