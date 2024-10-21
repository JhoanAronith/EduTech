/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Edutech.Controlador;

import com.Edutech.Modelo.Alumno;
import com.Edutech.Service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoService.obtenerTodosLosAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable int id) {
        return alumnoService.obtenerAlumnoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alumno guardarAlumno(@RequestBody Alumno alumno) {
        return alumnoService.guardarAlumno(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumnoActualizado) {
        return alumnoService.obtenerAlumnoPorId(id)
                .map(alumno -> {
                    alumno.setNombre(alumnoActualizado.getNombre());
                    alumno.setApellido(alumnoActualizado.getApellido());
                    alumno.setEmail(alumnoActualizado.getEmail());
                    alumno.setTelefono(alumnoActualizado.getTelefono());
                    alumno.setDireccion(alumnoActualizado.getDireccion());
                    alumnoService.actualizarAlumno(alumno);
                    return ResponseEntity.ok(alumno);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable int id) {
        if (alumnoService.obtenerAlumnoPorId(id).isPresent()) {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
