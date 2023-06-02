package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/demo")
    public String showDemo()
    {
        return "login";
    }

    @GetMapping("/admin")
    public String showAdminDemo(){ return "adminSession";}

    @GetMapping("/admin/userList")
    public String showUserList(Model model)
    {
        List<UserEntity> ulist = userRepository.findAll();
        model.addAttribute("ulist",ulist);
        return "adminSession";
    }

    @GetMapping("/user")
    public String showUserDemo(){ return "userSession";}

    @GetMapping("/user/{username}")
    public String showUserInfo(@PathVariable String username, Model model)
    {
        Optional<UserEntity> ue = userRepository.findByUsername(username);
        model.addAttribute("ue",ue);
        return "userSession";
    }
}
