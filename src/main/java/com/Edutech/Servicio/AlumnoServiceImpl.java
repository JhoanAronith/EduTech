package com.Edutech.Servicio;

import com.Edutech.Modelo.Alumno;
import com.Edutech.dao.AlumnoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoDAO alumnoDAO;
    @Transactional
    @Override
    public List<Alumno> get() {
        return alumnoDAO.get();
    }
    @Transactional
    @Override
    public Alumno get(int id_alumno) {
        return alumnoDAO.get(id_alumno);
    }
    @Transactional
    @Override
    public void save(Alumno alumno) {
        alumnoDAO.save(alumno);
    }
    @Transactional
    @Override
    public void update(Alumno alumno) {
        alumnoDAO.update(alumno);
    }
    @Transactional
    @Override
    public void delete(int id_alumno) {
        alumnoDAO.delete(id_alumno);
    }
    
}
