/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Edutech.dao;

import com.Edutech.Modelo.Curso;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface CursoRepositorio extends JpaRepository<Curso, Long>{
    @Query("SELECT c FROM Curso c WHERE" + " CONCAT(c.id_curso, c.titulo, c.duracion, c.descripcion, c.categoria, c.nivel)" + " LIKE %?1%")
    public List<Curso> findAll(String palabraClave);
    
    List<Curso> findByTituloContaining(String palabraClave, Sort sort);
}
