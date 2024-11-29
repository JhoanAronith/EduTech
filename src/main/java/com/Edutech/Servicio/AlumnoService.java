package com.Edutech.Servicio;

import com.Edutech.Modelo.Alumno;
import java.util.List;

public interface AlumnoService {

    public List<Alumno> get();
    public Alumno get(int id_alumno);
    public void save(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(int id_alumno);


}
