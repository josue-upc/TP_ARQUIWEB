package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.EventoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<EventoEntidad, Long> {

}