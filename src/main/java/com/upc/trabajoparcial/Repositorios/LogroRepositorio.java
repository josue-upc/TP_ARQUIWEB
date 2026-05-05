package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.LogroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogroRepositorio extends JpaRepository<LogroEntidad, Long> {
}