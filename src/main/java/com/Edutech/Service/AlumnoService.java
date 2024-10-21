/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Edutech.Service;

/**
 *
 * @author brend
 */
import com.Edutech.Modelo.Alumno;
import com.Edutech.Modelo.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerAlumnoPorId(int id_alumno) {
        return alumnoRepository.findById(id_alumno);
    }

    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(int id_alumno) {
        alumnoRepository.deleteById(id_alumno);
    }

    public Alumno actualizarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}
