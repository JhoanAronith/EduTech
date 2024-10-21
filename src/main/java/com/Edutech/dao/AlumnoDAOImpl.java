package com.Edutech.dao;

import com.Edutech.Modelo.Alumno;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Alumno> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Alumno> query = currentSession.createQuery("from Alumno order by name", Alumno.class);
        List<Alumno> list = query.getResultList();
        return list;
    }

    @Override
    public Alumno get(int id_alumno) {
        Session currentSession = entityManager.unwrap(Session.class);
        Alumno alumnoObj = currentSession.get(Alumno.class, id_alumno);
        return alumnoObj;
    }

    @Override
    public void save(Alumno alumno) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(alumno);
    }

    @Override
    public void update(Alumno alumno) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(alumno);
    }

    @Override
    public void delete(int id_alumno) {
        Session currentSession = entityManager.unwrap(Session.class);
        Alumno alumnoObj = currentSession.get(Alumno.class, id_alumno);
        currentSession.delete(alumnoObj);
    }

}
