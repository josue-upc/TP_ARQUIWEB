package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<RolEntidad, Long> {
}
