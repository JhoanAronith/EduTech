package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;

    @NotEmpty(message = "Ingrese el título del curso.")
    @Size(max = 255)
    @Column(nullable = false)
    private String titulo;

    @NotNull(message = "La duración es obligatoria.")
    private Integer duracion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @NotEmpty(message = "Ingrese la categoría del curso.")
    @Size(max = 100)
    @Column(nullable = false)
    private String categoria;

    @NotEmpty(message = "Ingrese el nivel del curso.")
    @Size(max = 50)
    @Column(nullable = false)
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "certificacion_id")
    private Certificacion certificacion;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Modulo> modulos;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Examen> examenes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<RegistroCurso> registros;

    public Curso() {
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    public List<RegistroCurso> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroCurso> registros) {
        this.registros = registros;
    }
    
    
    
}