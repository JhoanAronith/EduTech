package com.Edutech.Controlador;

import com.Edutech.Modelo.Curso;
import com.Edutech.Modelo.Modulo;
import com.Edutech.Servicio.CursoServicio;
import com.Edutech.Servicio.ModuloServicio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class CursoController {

    @Autowired
    private CursoServicio cursoServicio;

    @Autowired
    private ModuloServicio moduloServicio;

    /*@RequestMapping("/")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Curso> listaCursos = cursoServicio.listAll(palabraClave);
        modelo.addAttribute("listaCursos", listaCursos);
        modelo.addAttribute("palabraClave", palabraClave);
        modelo.addAttribute("curso", new Curso());
        return "index";
    }*/
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarCursos(
            @ModelAttribute("curso") Curso curso,
            @RequestParam Map<String, String> allParams) {

        cursoServicio.save(curso);

        List<Modulo> modulos = new ArrayList<>();
        int moduloCount = Integer.parseInt(allParams.get("cantidadModulos"));

        for (int i = 1; i <= moduloCount; i++) {
            String titulo = allParams.get("module-" + i + "-title");
            String videoLink = allParams.get("module-" + i + "-videoLink");

            if (titulo != null && !titulo.isEmpty()) {
                Modulo modulo = new Modulo();
                modulo.setTitulo(titulo);
                modulo.setVideoLink(videoLink);
                modulo.setCurso(curso);
                modulos.add(modulo);
            }
        }
        moduloServicio.saveAll(modulos);
        return "redirect:/admin-edutech";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarCurso(@PathVariable(name = "id") Long id) {
        Curso curso = cursoServicio.get(id);
        ModelAndView modelo = new ModelAndView("admin/editarCurso");
        modelo.addObject("curso", curso);
        modelo.addObject("modulos", curso.getModulos());
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable(name = "id") Long id) {
        cursoServicio.delete(id);
        return "redirect:/admin-edutech/cursos";
    }

    @GetMapping("/cursos-edutech")
    public String verCursos(Model model) {
        List<Curso> listaCursos = cursoServicio.listAll(null, "asc");
        model.addAttribute("listaCursos", listaCursos);
        return "cursos";  // Asegúrate de que el nombre de la vista coincida con el nombre del archivo HTML
    }

    @GetMapping("/curso/{id}")
    public String verCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoServicio.get(id);
        model.addAttribute("curso", curso);
        model.addAttribute("modulos", curso.getModulos());
        return "curso";
    }
}
