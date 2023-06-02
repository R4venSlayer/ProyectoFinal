package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.repository.UserRepository;
import com.example.ProyectoFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RegistroControlador {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String iniciarSesion()
    {
        return "login";
    }

    @GetMapping("/")
    public String showInitSite()
    {
        return "index";
    }

    @GetMapping("/demo")
    public String showDemo()
    {
        return "login";
    }


    @GetMapping("/admin/userList")
    public String showUserList(Model model)
    {
        model.addAttribute("ul",userService.listAllUsers());
        return "adminSession";
    }

    @GetMapping("/user/{username}")
    public String showUserInfo(@PathVariable String username, Model model)
    {
        UserEntity ue = userRepository.findByUsername(username);
        model.addAttribute("ue",ue);
        return "userSession";
    }
}
