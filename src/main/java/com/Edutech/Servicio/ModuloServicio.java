/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Edutech.Servicio;

import com.Edutech.Modelo.Modulo;
import com.Edutech.dao.ModuloRepositorio;
import com.app_PracticeModal.entities.Modulo;
import com.app_PracticeModal.repository.ModuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloServicio {
    
    @Autowired
    private ModuloRepositorio moduloRepositorio;

    public void saveAll(List<Modulo> modulos){
        moduloRepositorio.saveAll(modulos);
    }
}
