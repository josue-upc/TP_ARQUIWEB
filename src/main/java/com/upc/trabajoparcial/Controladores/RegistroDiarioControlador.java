package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.Servicios.RegistroDiarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RegistroDiarioControlador {

    @Autowired
    private RegistroDiarioServicio servicio;

    // US39: POST /api/v1/emociones/registrar
    @PostMapping("/emotions/log")
    public RegistroDiarioDTO registrarEmocion(@RequestBody RegistroDiarioDTO dto) {
        return servicio.registrarEmocion(dto);
    }

    // US05: GET /api/v1/estadisticas/recibir
    @GetMapping("/statistics/usage")
    public Map<String, Integer> obtenerEstadisticasTiempo(@RequestParam Long usuarioId) {
        return servicio.obtenerEstadisticas(usuarioId);
    }
}
