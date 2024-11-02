package com.Edutech.Controlador;

import com.Edutech.Modelo.Curso;
import com.Edutech.Modelo.Modulo;
import com.Edutech.Servicio.CertificacionService;
import com.Edutech.Servicio.CursoServicio;
import com.Edutech.Servicio.ModuloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador_Principal {

    @Autowired
    private CertificacionService certificacionService;

    @Autowired
    private CursoServicio cursoServicio;
    
    @Autowired
    private ModuloServicio moduloServicio;

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
    public String Curso(Model modelo) {
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
    /*@GetMapping("/admin-edutech/cursos")
    public String AdminCursos(Model modelo) {
        return ("/admin/cursos");
    }*/
 /**/
    @GetMapping("/admin-edutech/index")
    public String AdminNuevoCurso(Model modelo) {
        modelo.addAttribute("curso", new Curso());
        modelo.addAttribute("certificaciones", certificacionService.listarCertificaciones());
        return ("/admin/nuevoCurso");
    }

//    @GetMapping("/admin-edutech/administradores")
//    public String AdminAdministradores(Model modelo) {
//        return ("/admin/administradores");
//    }
    @GetMapping("/admin-edutech/dashboard")
    public String AdminDashboard(Model modelo) {
        return ("/admin/dashboard");
    }

    @GetMapping("/admin-edutech/inscripciones")
    public String AdminInscripciones(Model modelo) {
        return ("/admin/inscripciones");
    }

    /**/
    @GetMapping("/admin-edutech/cursos")
    public String mostrarCursos(@RequestParam(value = "palabraClave", required = false) String palabraClave,
                                @RequestParam(value = "orden", defaultValue = "asc") String orden,
                                Model modelo) {
        
        List<Curso> listaCursos = cursoServicio.listAll(palabraClave, orden);
        
        List<Modulo> listaModulos = moduloServicio.listAll();
        
        modelo.addAttribute("listaCursos", listaCursos);
        modelo.addAttribute("listaModulos", listaModulos);
        modelo.addAttribute("palabraClave", palabraClave);
        modelo.addAttribute("orden", orden);
        return "/admin/cursos";
    }
}
