package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroDiarioRepositorio extends JpaRepository<RegistroDiarioEntidad, Long> {
    Optional<RegistroDiarioEntidad> findByUsuarioIdAndFechaRegistro(Long usuarioId, LocalDate fechaRegistro);
    List<RegistroDiarioEntidad> findByUsuarioIdOrderByFechaRegistroDesc(Long usuarioId);
}
