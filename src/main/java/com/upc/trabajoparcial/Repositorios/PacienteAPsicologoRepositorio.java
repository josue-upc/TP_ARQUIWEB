package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.PacienteAPsicologoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteAPsicologoRepositorio extends JpaRepository<PacienteAPsicologoEntidad, Long>{
    // Cuenta cuántos pacientes tiene asignado este psicólogo
    @Query("SELECT COUNT(p) FROM PacienteAPsicologoEntidad p WHERE p.psicologo.id = :psicologoId")
    Long countPacientesByPsicologoId(@Param("psicologoId") Long psicologoId);

    // US10: Traer toda la lista de pacientes de un psicólogo
    @Query("SELECT p FROM PacienteAPsicologoEntidad p WHERE p.psicologo.id = :psicologoId")
    List<PacienteAPsicologoEntidad> findPacientesByPsicologoId(@Param("psicologoId") Long psicologoId);
}
