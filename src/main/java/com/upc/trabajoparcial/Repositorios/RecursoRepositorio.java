package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.RecursoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepositorio extends JpaRepository<RecursoEntidad, Long> {

}