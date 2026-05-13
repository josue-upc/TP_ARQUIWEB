package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
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
    // --- US39: Registrar emociones diarias ---
    public RegistroDiarioDTO registrarEmocion(RegistroDiarioDTO dto) {
        // 1. Mapeamos los datos básicos
        RegistroDiarioEntidad entidad = modelMapper.map(dto, RegistroDiarioEntidad.class);

        // 2. FORZAMOS la asignación manual del usuario
        if (dto.getUsuario() != null && dto.getUsuario().getId() != null) {
            UsuarioEntidad usuarioEncontrado = usuarioRepositorio.findById(dto.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + dto.getUsuario().getId()));
            entidad.setUsuario(usuarioEncontrado);
        } else {
            throw new RuntimeException("El ID del usuario es obligatorio para registrar una emoción.");
        }

        // 3. Forzamos la fecha si es que Postman no la está mandando bien
        if (entidad.getFechaRegistro() == null) {
            entidad.setFechaRegistro(java.time.LocalDate.now());
        }

        // 4. Guardamos y devolvemos
        RegistroDiarioEntidad guardado = registroRepositorio.save(entidad);
        return modelMapper.map(guardado, RegistroDiarioDTO.class);
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
