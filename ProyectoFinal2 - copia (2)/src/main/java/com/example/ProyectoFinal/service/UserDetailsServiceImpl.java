package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.dto.UsuarioRegistroDTO;
import com.example.ProyectoFinal.model.Authority;
import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.repository.AuthorityRepository;
import com.example.ProyectoFinal.repository.UserRepository;

import com.example.ProyectoFinal.utils.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.ProyectoFinal.utils.AuthorityName.*;

@Service
public class UserDetailsServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    public UserDetailsServiceImpl(UserRepository userRepository,AuthorityRepository authorityRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UsuarioRegistroDTO registroDTO) {
        System.out.println(registroDTO.getFirst_name());

        String fn = registroDTO.getFirst_name();
        String ln = registroDTO.getLast_name();
        String un = registroDTO.getUsername();
        String ps = registroDTO.getPassword();
        String db = registroDTO.getB_date();


        UserEntity ue = new UserEntity(fn,ln,un,ps,db,List.of(this.authorityRepository.findByName(AuthorityName.USER).get()));
        System.out.println(ue.toString());
        return userRepository.save(ue);
    }

    @Override
    public List<UserEntity> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity actualizarEstudiante(UserEntity ue) {
        return userRepository.save(ue);
    }


    @Override
    public void eliminarEstudiante(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null)
        {
            throw new UsernameNotFoundException("usuario o contraseña no valida");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), mapearAutoridadesRoles(userEntity.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Authority> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
    }
}
