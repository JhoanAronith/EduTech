package com.Edutech.dao;

import com.Edutech.Modelo.*;
import java.util.List;

public interface AlumnoDAO {
    
    public List<Alumno> get();
    public Alumno get(int id_alumno);
    public void save(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(int id_alumno);
    
}
