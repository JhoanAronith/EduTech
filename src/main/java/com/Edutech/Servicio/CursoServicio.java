/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Edutech.Servicio;

import com.Edutech.Modelo.Curso;
import com.Edutech.dao.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.data.domain.Sort;

@Service
public class CursoServicio {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public List<Curso> listAll(String palabraClave, String orden) {
        Sort sort = "desc".equalsIgnoreCase(orden) ? Sort.by(Sort.Direction.DESC, "titulo") : Sort.by(Sort.Direction.ASC, "titulo");

        if (palabraClave != null && !palabraClave.isEmpty()) {
            return cursoRepositorio.findByTituloContaining(palabraClave, sort);
        }
        return cursoRepositorio.findAll(sort);
    }

    public Curso save(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    public Curso get(Long id) {
        return cursoRepositorio.findById(id).get();
    }

    public void delete(Long id) {
        cursoRepositorio.deleteById(id);
    }
}
