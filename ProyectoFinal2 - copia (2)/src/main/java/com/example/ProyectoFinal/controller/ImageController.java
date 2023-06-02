package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.ImageData;
import com.example.ProyectoFinal.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public ResponseEntity<List<ImageData>> getAllImages() {
        List<ImageData> images = storageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/publi")
    public String listarPublicaciones(Model model) {
        model.addAttribute("imageData", storageService.getAllImages());
        return "publicaciones";
    }


    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] imageData = storageService.downloadImage(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG) // Establecer el tipo de contenido de la respuesta como imagen PNG
                .body(imageData);
    }

}
