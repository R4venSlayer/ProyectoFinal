package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.ImageData;
import com.example.ProyectoFinal.repository.StorageRepository;
import com.example.ProyectoFinal.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file, String estado) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .estado(estado)
                .usuario(estado).build());
        if (imageData != null) {
            return "archivo subido existosamente : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public List<ImageData> getAllImages() {
        return repository.findAll();
    }




}