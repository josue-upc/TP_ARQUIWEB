package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.Servicios.AlertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaControlador {

    @Autowired
    private AlertaServicio alertaServicio;

    @PostMapping
    public ResponseEntity<AlertaDTO> crear(@RequestBody AlertaDTO dto) {
        return new ResponseEntity<>(alertaServicio.crear(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlertaDTO>> listarTodas() {
        return new ResponseEntity<>(alertaServicio.listarTodas(), HttpStatus.OK);
    }

    @PatchMapping("/{id}/leer")
    public ResponseEntity<Void> marcarLeida(@PathVariable Long id) {
        alertaServicio.marcarComoLeida(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // US33: Notificación de urgencia
    @PostMapping("/urgent/trigger")
    public ResponseEntity<String> alertaUrgente(@RequestParam String mensaje) {
        return new ResponseEntity<>(
                "Alerta urgente enviada: " + mensaje,
                HttpStatus.OK
        );
    }
}