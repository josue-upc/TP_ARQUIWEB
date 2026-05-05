package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.UsuarioLogroDTO;
import com.upc.trabajoparcial.Servicios.UsuarioLogroServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario-logros")
public class UsuarioLogroControlador {

    @Autowired
    private UsuarioLogroServicio usuarioLogroServicio;

    @PostMapping
    public ResponseEntity<UsuarioLogroDTO> crear(@Valid @RequestBody UsuarioLogroDTO dto) {
        return new ResponseEntity<>(usuarioLogroServicio.crear(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioLogroDTO>> listarTodos() {
        return new ResponseEntity<>(usuarioLogroServicio.listarTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioLogroServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}