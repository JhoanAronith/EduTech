package com.Edutech.Controlador;

import com.Edutech.Modelo.Administrador;
import com.Edutech.Servicio.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministradorController {

    @Autowired
    private AdministradorService adminService;

    @GetMapping("/admin-edutech/administradores")
    public String mostrarAdministradores(Model modelo) {
        Administrador admin = new Administrador();
        modelo.addAttribute("admin", admin);
        modelo.addAttribute("lista", adminService.get());
        return "admin/administradores";
    }

    @PostMapping("/guardarAdministrador")
    public String guardarAdmin(@ModelAttribute("admin") Administrador admin, Model modelo) {
        adminService.save(admin);
        return "redirect:/admin-edutech/administradores";
    }

    @GetMapping("/admin-edutech/administradores/eliminar/{id}")
    public String eliminarAdmin(@PathVariable Integer id) {
        adminService.delete(id);
        return "redirect:/admin-edutech/administradores";
    }
    //Validaciones
    //    @PostMapping("/guardarAdministrador")
    //    public String guardarAdm(@Valid @ModelAttribute("administrador") Administrador admin, BindingResult result, Model modelo) {
    //        if (result.hasErrors()) {
    //            modelo.addAttribute("admin", admin);
    //            return "/admin/administradores";
    //        }
    //    }
}
