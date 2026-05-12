package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.UsuarioLogroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioLogroRepositorio extends JpaRepository<UsuarioLogroEntidad, Long> {
      List<UsuarioLogroEntidad> findByUsuarioId(Long usuarioId);
}
