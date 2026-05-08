package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import com.upc.trabajoparcial.Repositorios.RegistroDiarioRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistroDiarioServicio {

    @Autowired
    private RegistroDiarioRepositorio registroRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    // --- US39: Registrar emociones diarias ---
    public RegistroDiarioDTO registrarEmocion(RegistroDiarioDTO dto) {
        RegistroDiarioEntidad entidad = modelMapper.map(dto, RegistroDiarioEntidad.class);

        // Adaptación: Sacamos el ID del usuario desde el objeto que dejó tu compañero
        if (dto.getUsuario() != null && dto.getUsuario().getId() != null) {
            entidad.setUsuario(usuarioRepositorio.findById(dto.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        }

        return modelMapper.map(registroRepositorio.save(entidad), RegistroDiarioDTO.class);
    }

    // --- US05: Recibir estadísticas de tiempo ---
    public Map<String, Integer> obtenerEstadisticas(Long usuarioId) {
        Integer totalActivos = registroRepositorio.sumarMinutosActivosPorUsuario(usuarioId);
        Integer totalDescanso = registroRepositorio.sumarMinutosDescansoPorUsuario(usuarioId);

        Map<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("minutosActivosTotales", totalActivos);
        estadisticas.put("minutosDescansoTotales", totalDescanso);
        return estadisticas;
    }
}
