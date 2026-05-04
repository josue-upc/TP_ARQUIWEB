package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {
}
