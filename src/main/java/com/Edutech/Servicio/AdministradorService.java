package com.Edutech.Servicio;

import com.Edutech.Modelo.Administrador;
import java.util.List;

public interface AdministradorService {
    
    public List<Administrador> get();
    public Administrador get(int id_administrador);
    public void save(Administrador admin);
    public void update(Administrador admin);
    public void delete(int id_administrador);
    
}
