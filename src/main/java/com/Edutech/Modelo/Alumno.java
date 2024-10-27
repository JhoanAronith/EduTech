package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100)
    @Column
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio.")
    @Size(max = 100)
    @Column
    private String apellido;
    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Size(max = 100)
    @Email
    @Column
    private String email;
    @Size(max = 15)
    @Column
    private String telefono;
    @Size(max = 255)
    @Column
    private String direccion;
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 255)
    @Column
    private String contrasena;
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Pago> pagos;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<RegistroCurso> registros;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<ExamenAlumno> examenes;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Certificacion> certificaciones;

    public Alumno() {

    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<RegistroCurso> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroCurso> registros) {
        this.registros = registros;
    }

    public List<ExamenAlumno> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<ExamenAlumno> examenes) {
        this.examenes = examenes;
    }

    public List<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

   

}
