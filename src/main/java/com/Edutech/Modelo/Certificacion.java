package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "certificacion")
public class Certificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_certificacion;

    @NotEmpty(message = "Ingrese el nombre de la certificación.")
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "certificacion", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Certificacion() {
    }

    public Integer getId_certificacion() {
        return id_certificacion;
    }

    public void setId_certificacion(Integer id_certificacion) {
        this.id_certificacion = id_certificacion;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }


}
