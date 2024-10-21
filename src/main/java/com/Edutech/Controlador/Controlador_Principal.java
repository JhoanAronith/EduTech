package com.Edutech.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador_Principal {
    @GetMapping("/inicio-edutech")
    public String Inicio(Model modelo) {
        return "inicio";
    }
    
    @GetMapping("/cursos-edutech")
    public String Cursos(Model modelo) {
        return "cursos";
    }
    
    @GetMapping("/login-edutech")
    public String Login(Model modelo) {
        return "login";
    }
    
    @GetMapping("/registro-edutech")
    public String Registro(Model modelo) {
        return ("registro");
    }
    
    @GetMapping("/perfil-edutech")
    public String Perfil(Model modelo) {
        return ("perfil");
    }
    
    @GetMapping("/pago-edutech")
    public String Pago(Model modelo) {
        return ("pago");
    }
    
    @GetMapping("/nosotros-edutech")
    public String Nosotros(Model modelo) {
        return ("nosotros");
    }
    
    @GetMapping("/curso-edutech")
    public String Curso(Model modelo){
        return ("curso");
    }
    
    @GetMapping("/certificaciones-edutech")
    public String Certificaciones(Model modelo) {
        return ("certificaciones");
    }
    
    @GetMapping("/categorias-edutech")
    public String Categorias(Model modelo) {
        return ("categorias");
    }
    
}