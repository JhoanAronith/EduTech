package com.Edutech.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AdministradorController {
    
    @GetMapping("/admin-edutech/administradores")
    public String nuevoAdministrador(Model modelo) {
        return"/admin/administradores";
    }
    
}
