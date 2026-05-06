package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.RecursoDTO;
import com.upc.trabajoparcial.Servicios.RecursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recursos")
public class RecursoControlador {

    @Autowired
    private RecursoServicio recursoServicio;

    @PostMapping
    public ResponseEntity<RecursoDTO> crear(@RequestBody RecursoDTO dto) {
        return new ResponseEntity<>(recursoServicio.crear(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> listarTodos() {
        return new ResponseEntity<>(recursoServicio.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> obtener(@PathVariable UUID id) {
        return new ResponseEntity<>(recursoServicio.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        recursoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}