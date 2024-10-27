package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="examen")
public class Examen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_examen;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @Lob
    private String descripcion;

    @NotNull
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<ExamenAlumno> examenesAlumnos;

    
    
    public Integer getId_examen() {
        return id_examen;
    }

    public void setId_examen(Integer id_examen) {
        this.id_examen = id_examen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<ExamenAlumno> getExamenesAlumnos() {
        return examenesAlumnos;
    }

    public void setExamenesAlumnos(List<ExamenAlumno> examenesAlumnos) {
        this.examenesAlumnos = examenesAlumnos;
    }
    
}
