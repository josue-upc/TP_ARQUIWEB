package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.PacientesAPsicologoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteAPsicologoRepositorio extends JpaRepository<PacientesAPsicologoEntidad, Long> {
    List<PacientesAPsicologoEntidad> findByPsicologoId(Long psicologoId);
    Optional<PacientesAPsicologoEntidad> findByPsicologoIdAndPacienteId(Long psicologoId, Long pacienteId);
    boolean existsByPsicologoIdAndPacienteId(Long psicologoId, Long pacienteId);
}
