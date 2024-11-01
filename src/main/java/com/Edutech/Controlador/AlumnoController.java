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

    @PostMapping("/guardarAlumno")
    public String guardarEmp(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("alumno", alumno);
            return "registro";
        }
        alumnoService.save(alumno);
        return "redirect:/pago-edutech";
    }

    @GetMapping("/admin-edutech/usuarios")
    public String get(Model modelo) {
        modelo.addAttribute("lista", alumnoService.get());
        return "/admin/usuarios";
    }

    @GetMapping("/admin-edutech/usuarios/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        alumnoService.delete(id);
        return "redirect:/admin-edutech/usuarios";
    }

}
