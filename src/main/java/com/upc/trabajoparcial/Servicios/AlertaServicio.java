package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.Entidades.AlertaEntidad;
import com.upc.trabajoparcial.Repositorios.AlertaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaServicio {

    @Autowired
    private AlertaRepositorio alertaRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AlertaDTO crear(AlertaDTO dto) {
        AlertaEntidad entidad = modelMapper.map(dto, AlertaEntidad.class);
        entidad = alertaRepositorio.save(entidad);
        return modelMapper.map(entidad, AlertaDTO.class);
    }

    public List<AlertaDTO> listarTodas() {
        return alertaRepositorio.findAll().stream()
                .map(alerta -> modelMapper.map(alerta, AlertaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void marcarComoLeida(Long id) {
        AlertaEntidad alerta = alertaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
        alerta.setLeido(true);
        alertaRepositorio.save(alerta);
    }
}