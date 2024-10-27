package com.Edutech.Controlador;

import com.Edutech.Modelo.Alumno;
import com.Edutech.Servicio.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String guardarEmp(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("alumno", alumno); // Asegura que el objeto se mantenga en caso de error
            return "registro"; // Cambia a la vista correcta
        }
        alumnoService.save(alumno);
        return "redirect:/pago-edutech";
    }

}
