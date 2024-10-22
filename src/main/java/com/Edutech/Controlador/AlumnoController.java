package com.Edutech.Controlador;

import com.Edutech.Modelo.Alumno;
import com.Edutech.Servicio.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    
    @GetMapping("/registro-edutech")
    public String nuevoAlumno(Model modelo) {
        Alumno alumno = new Alumno();
        modelo.addAttribute("alumno", alumno);
        return "registro";
    }
    
    @GetMapping("/guardarAlumno")
    public String guardarEmp(@ModelAttribute("alumno")Alumno alumno) {
        alumnoService.save(alumno);
        return "redirect:/pago-edutech";
    }
}