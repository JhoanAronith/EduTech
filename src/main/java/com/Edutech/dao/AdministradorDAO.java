package com.Edutech.dao;

import com.Edutech.Modelo.*;
import java.util.List;

public interface AdministradorDAO {
    
    public List<Administrador> get();
    public Administrador get(int id_administrador);
    public void save(Administrador admin);
    public void update(Administrador admin);
    public void delete(int id_administrador);
    
}
