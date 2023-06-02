package com.example.ProyectoFinal.service;


import com.app.web.entidad.Seguidor;

import java.util.List;

public interface SeguidorService {

    public List<Seguidor> listarTodosLosSeguidores();
    public Seguidor guardarSeguidor(Seguidor seguidor);
    public Seguidor obtenerSeguidorPorId(int id);
    public Seguidor actualizarSeguidor(Seguidor seguidor);
    public void eliminarIdSeguir(int id);

}
