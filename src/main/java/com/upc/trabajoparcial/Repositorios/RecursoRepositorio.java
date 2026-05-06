package com.upc.trabajoparcial.Repositorios;

import com.upc.trabajoparcial.Entidades.RecursoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecursoRepositorio extends JpaRepository<RecursoEntidad, UUID> {
}