package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.AlertaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepositorio extends JpaRepository<AlertaEntidad, Long> {
    @Query("SELECT COUNT(a) FROM AlertaEntidad a WHERE a.receptor.id = :receptorId AND a.leido = false")
    Long countAlertasNoLeidasPorReceptor(@Param("receptorId") Long receptorId);
}