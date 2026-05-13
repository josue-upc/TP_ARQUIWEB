package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.DTOs.UsuarioUpdateDTO;
import com.upc.trabajoparcial.Servicios.LogroServicio;
import com.upc.trabajoparcial.Servicios.RegistroDiarioServicio;
import com.upc.trabajoparcial.Servicios.UsuarioLogroServicio;
import com.upc.trabajoparcial.Servicios.UsuarioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/emotions")
public class RegistroDiarioControlador {

    // 1. Agrupamos todas las inyecciones de dependencias al inicio
    @Autowired
    private RegistroDiarioServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private LogroServicio logroServicio;

    @Autowired
    private UsuarioLogroServicio usuarioLogroServicio;


    // US39: POST /api/v1/emotions/log
    @PostMapping("/log")
    public RegistroDiarioDTO registrarEmocion(@RequestBody RegistroDiarioDTO dto) {
        return servicio.registrarEmocion(dto);
    }

    // US05: GET /api/v1/emotions/statistics/usage
    @GetMapping("/statistics/usage")
    public Map<String, Integer> obtenerEstadisticasTiempo(@RequestParam Long usuarioId) {
        return servicio.obtenerEstadisticas(usuarioId);
    }

    // POST /api/v1/emotions/goals/daily
    @PostMapping("/goals/daily")
    public ResponseEntity<String> guardarMetaDiaria(
            @RequestParam Long usuarioId,
            @RequestBody UsuarioUpdateDTO body) {

        usuarioServicio.guardarMetaDiaria(usuarioId, body.getDailyGoalMinutes());
        return ResponseEntity.ok("Meta guardada");
    }

    // GET /api/v1/emotions/gamification/status
    @GetMapping("/gamification/status")
    public Map<String, Object> obtenerEstadoGamificacion(@RequestParam Long usuarioId) {
        Integer puntos = usuarioServicio.obtenerPuntos(usuarioId);
        return logroServicio.obtenerEstadoGamificacion(puntos);
    }

    // GET /api/v1/emotions/users/{userId}/achievements
    @GetMapping("/users/{userId}/achievements")
    public Map<String, Object> listarLogrosUsuario(@PathVariable Long userId) {
        return usuarioLogroServicio.listarLogrosPorUsuario(userId);
    }
}