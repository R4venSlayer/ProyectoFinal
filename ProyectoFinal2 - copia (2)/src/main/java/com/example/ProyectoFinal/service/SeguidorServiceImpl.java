package com.example.ProyectoFinal.service;


import com.app.web.entidad.Seguidor;
import com.app.web.repositorio.SeguidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguidorServiceImpl implements SeguidorService{

    @Autowired
    private SeguidorRepository repository;
    @Override
    public List<Seguidor> listarTodosLosSeguidores() {
        return repository.findAll();
    }
    public Seguidor guardarSeguidor(Seguidor seguidor){
        return repository.save(seguidor);
    }

    @Override
    public Seguidor obtenerSeguidorPorId(int id) {
        return repository.findById((long) id).get();
    }

    @Override
    public Seguidor actualizarSeguidor(Seguidor estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void eliminarIdSeguir(int id) {
        repository.deleteById((long) id);
    }
}
