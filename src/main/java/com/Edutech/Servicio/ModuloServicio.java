package com.Edutech.Servicio;

import com.Edutech.Modelo.Modulo;
import com.Edutech.dao.ModuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloServicio {

    @Autowired
    private ModuloRepositorio moduloRepositorio;

    public void saveAll(List<Modulo> modulos) {
        moduloRepositorio.saveAll(modulos);
    }

    public List<Modulo> listAll() {
        return moduloRepositorio.findAll();
    }
}
