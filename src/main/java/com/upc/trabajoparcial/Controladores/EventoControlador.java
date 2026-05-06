package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.EventoDTO;
import com.upc.trabajoparcial.Servicios.EventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoControlador {

    @Autowired
    private EventoServicio eventoServicio;

    @PostMapping
    public ResponseEntity<EventoDTO> crear(@RequestBody EventoDTO dto) {
        return new ResponseEntity<>(eventoServicio.crear(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listarTodos() {
        return new ResponseEntity<>(eventoServicio.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obtener(@PathVariable Long id) {
        return new ResponseEntity<>(eventoServicio.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eventoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}