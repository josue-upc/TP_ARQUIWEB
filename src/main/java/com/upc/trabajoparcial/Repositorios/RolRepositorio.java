package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<RolEntidad, Long> {
    // Esto nos servirá para verificar si el rol ya existe antes de crearlo
    Optional<RolEntidad> findByName(String name);
}
