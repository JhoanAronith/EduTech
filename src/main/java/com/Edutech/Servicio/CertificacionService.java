package com.Edutech.Servicio;

import com.Edutech.Modelo.Certificacion;
import com.Edutech.dao.CertificacionRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Usuario
 */
@Service
public class CertificacionService {

    @Autowired
    private CertificacionRepositorio certificacionRepositorio;

    public List<Certificacion> listarCertificaciones() {
        return certificacionRepositorio.findAll();
    }

    public Certificacion guardarCertificacion(Certificacion certificacion) {
        return certificacionRepositorio.save(certificacion);
    }

    public Certificacion obtenerCertificacionPorId(Integer id) {
        return certificacionRepositorio.findById(id).orElse(null);
    }

    public void eliminarCertificacion(Integer id) {
        certificacionRepositorio.deleteById(id);
    }

}
