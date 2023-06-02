package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.UserEntity;
import com.example.ProyectoFinal.service.SeguidorService;
import com.example.ProyectoFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/seguidores")
public class SeguidoresControlador {
    @Autowired
    private UserService userService;
    @Autowired
    private SeguidorService seguidorService;

    @GetMapping({"/", ""})
    public String listarUsuarios(Model model){
        model.addAttribute("ul",userService.listAllUsers());
        return "EstudiantesSeguidores";//Nos retorna al archivo estudiantes
    }
    @GetMapping("/nuevo")
    public String mostrarFormularioRegistroEstudiante(Model modelo){
        UserEntity ue = new UserEntity();
        modelo.addAttribute("estudiante",ue);
        return "crear_Estudiante";
    }

    @PostMapping("")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        service.guardarEstudiante(estudiante);
        return "redirect:EstudiantesSeguidores";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante",service.obtenerEstudiantePorId(id));
        return "edite_user";
    }
    @PostMapping("/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model model){
        Estudiante estudianteExistente = service.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        service.actualizarEstudiante(estudianteExistente);
        return "redirect:/EstudiantesSeguidores";
    }

    @PostMapping("/seguir")
    public String seguirUsuario(@RequestBody Seguidor s){

        System.out.println("este este "+ s.getSeguido()+" este ");
        service1.guardarSeguidor(s);
        return "redirect:/EstudiantesSeguidores.html";

    }

    @GetMapping("/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        service.eliminarEstudiante(id);
        return "redirect:/EstudiantesSeguidores";
    }

}
