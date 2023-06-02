package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.dto.UsuarioRegistroDTO;
import com.example.ProyectoFinal.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService{
    public UserEntity save(UsuarioRegistroDTO registroDTO);
    public List<UserEntity> listAllUsers();

    public UserEntity actualizarEstudiante(UserEntity ue);

    public void eliminarEstudiante(Long id);

}
