package com.Edutech.Servicio;

import com.Edutech.Modelo.*;
import com.Edutech.dao.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorDAO adminDAO;

    @Transactional
    @Override
    public List<Administrador> get() {
        return adminDAO.get();
    }

    @Transactional
    @Override
    public Administrador get(int id_administrador) {
        return adminDAO.get(id_administrador);
    }

    @Transactional
    @Override
    public void save(Administrador admin) {
        adminDAO.save(admin);
    }

    @Transactional
    @Override
    public void update(Administrador admin) {
        adminDAO.update(admin);
    }

    @Transactional
    @Override
    public void delete(int id_administrador) {
        adminDAO.delete(id_administrador);
    }

}
