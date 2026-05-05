package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.AlertaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepositorio extends JpaRepository<AlertaEntidad, Long> {
}