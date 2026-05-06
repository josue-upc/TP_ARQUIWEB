package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.Servicios.RegistroDiarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registros-diarios")
public class RegistroDiarioControlador {

    @Autowired
    private RegistroDiarioServicio registroDiarioServicio;

    @PostMapping("/registrar")
    public RegistroDiarioDTO registrar(@RequestBody RegistroDiarioDTO dto) {
        return registroDiarioServicio.registrar(dto);
    }

    @GetMapping("/listar/{usuarioId}")
    public List<RegistroDiarioDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return registroDiarioServicio.listarPorUsuario(usuarioId);
    }

    @GetMapping("/hoy/{usuarioId}")
    public RegistroDiarioDTO obtenerDeHoy(@PathVariable Long usuarioId) {
        return registroDiarioServicio.obtenerDeHoy(usuarioId);
    }

    @PutMapping("/actualizar/{id}")
    public RegistroDiarioDTO actualizar(@PathVariable Long id, @RequestBody RegistroDiarioDTO dto) {
        return registroDiarioServicio.actualizar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        registroDiarioServicio.eliminar(id);
    }
}
