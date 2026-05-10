package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.Entidades.AlertaEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
import com.upc.trabajoparcial.Repositorios.AlertaRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
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

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Transactional
    public AlertaDTO crear(AlertaDTO dto) {
        AlertaEntidad entidad = new AlertaEntidad();
        UsuarioEntidad receptor = usuarioRepositorio.findById(dto.getReceptorId())
                .orElseThrow(() -> new RuntimeException("Receptor no encontrado"));
        entidad.setReceptor(receptor);

        if (dto.getEmisorAlertaId() != null) {
            UsuarioEntidad emisor = usuarioRepositorio.findById(dto.getEmisorAlertaId())
                    .orElseThrow(() -> new RuntimeException("Emisor no encontrado"));
            entidad.setEmisorAlerta(emisor);
        }

        entidad.setTipo(dto.getTipo());
        entidad.setMensaje(dto.getMensaje());
        entidad.setLeido(false);entidad.setFechaCreacion(java.time.LocalDateTime.now());

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
