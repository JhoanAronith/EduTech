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
    
    @GetMapping("/admin-edutech")
    public String Admistrador(Model modelo) {
        return ("/admin/inicio");
    }
    
//    @GetMapping("/admin-edutech/usuarios")
//    public String AdminAlumnos(Model modelo) {
//        return ("/admin/usuarios");
//    }
    
    @GetMapping("/admin-edutech/cursos")
    public String AdminCursos(Model modelo) {
        return ("/admin/cursos");
    }
    
    @GetMapping("/admin-edutech/nuevoCurso")
    public String AdminNuevoCurso(Model modelo) {
        return ("/admin/nuevoCurso");
    }
    
    @GetMapping("/admin-edutech/administradores")
    public String AdminAdministradores(Model modelo) {
        return ("/admin/administradores");
    }
    
    @GetMapping("/admin-edutech/dashboard")
    public String AdminDashboard(Model modelo) {
        return ("/admin/dashboard");
    }
    
    @GetMapping("/admin-edutech/inscripciones")
    public String AdminInscripciones(Model modelo) {
        return ("/admin/inscripciones");
    }
    
}