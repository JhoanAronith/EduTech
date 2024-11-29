package com.Edutech.Controlador;

import com.Edutech.Modelo.Alumno;
import com.Edutech.Servicio.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControladorPrueba {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumno")
    public List<Alumno> get() {
        return alumnoService.get();
    }
}
