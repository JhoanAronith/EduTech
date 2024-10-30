/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Edutech.Servicio;

import com.Edutech.Modelo.Curso;
import com.Edutech.dao.CursoRepositorio;
import com.app_PracticeModal.entities.Curso;
import com.app_PracticeModal.repository.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CursoServicio {
    
    @Autowired
    private CursoRepositorio cursoRepositorio;

    public List<Curso> listAll(String palabraClave){
        if(palabraClave != null){
            return cursoRepositorio.findAll(palabraClave);
        }
        return cursoRepositorio.findAll();
    }

    public void save(Curso curso){
        cursoRepositorio.save(curso);
    }

    public Curso get(Long id){
        return cursoRepositorio.findById(id).get();
    }

    public void delete(Long id) {
        cursoRepositorio.deleteById(id);
    }
}
