package com.Edutech.dao;

import com.Edutech.Modelo.Administrador;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministradorDAOImpl implements AdministradorDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Administrador> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Administrador> query = currentSession.createQuery("from Administrador", Administrador.class);
        List<Administrador> list = query.getResultList();
        return list;
    }

    @Override
    public Administrador get(int id_administrador) {
        Session currentSession = entityManager.unwrap(Session.class);
        Administrador adminObj = currentSession.get(Administrador.class, id_administrador);
        return adminObj;
    }

    @Override
    public void save(Administrador admin) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(admin);
    }

    @Override
    public void update(Administrador admin) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(admin);
    }

    @Override
    public void delete(int id_administrador) {
        Session currentSession = entityManager.unwrap(Session.class);
        Administrador adminObj = currentSession.get(Administrador.class, id_administrador);
        currentSession.delete(adminObj);
    }

}
