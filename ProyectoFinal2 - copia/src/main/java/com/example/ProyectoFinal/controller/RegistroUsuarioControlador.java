package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.dto.UsuarioRegistroDTO;
import com.example.ProyectoFinal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UserService userService;

    public RegistroUsuarioControlador(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userE")
    public UsuarioRegistroDTO returnNewUserReg()
    {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String showFormReg()
    {
        return "registro";
    }

    @PostMapping
    public String regAccountUser(@ModelAttribute("userE") UsuarioRegistroDTO registroDTO)
    {
        userService.save(registroDTO);
        return "redirect:/registro?exito";
    }

}
