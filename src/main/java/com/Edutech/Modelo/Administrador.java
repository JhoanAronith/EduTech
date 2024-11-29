package com.Edutech.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_administrador;

    @NotEmpty(message = "Ingrese su nombre.")
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "Ingrese su correo electrónico.")
    @Size(max = 100)
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "La contraseña es obligatoria.")
    @Size(min = 8, max = 255)
    @Column(nullable = false)
    private String contrasena;

    public Administrador() {
    }

    public Integer getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Integer id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



}

