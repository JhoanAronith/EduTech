package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name="examenAlumno")
public class ExamenAlumno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_examen_alumno;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal nota;

    @ManyToOne
    @JoinColumn(name = "examen_id", nullable = false)
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    public ExamenAlumno() {
    }

    public Integer getId_examen_alumno() {
        return id_examen_alumno;
    }

    public void setId_examen_alumno(Integer id_examen_alumno) {
        this.id_examen_alumno = id_examen_alumno;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    
    
    
}
