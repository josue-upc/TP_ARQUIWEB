package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.ChatDTO;
import com.upc.trabajoparcial.DTOs.MensajeDTO;
import com.upc.trabajoparcial.Servicios.ChatServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Aquí ya arreglamos el import que estaba mal
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chats")
public class ChatControlador {

    @Autowired
    private ChatServicio service;

    @PostMapping("/crear")
    public ChatDTO crear(@RequestBody ChatDTO dto) {
        return service.crear(dto);
    }

    @GetMapping("/listar-todos")
    public List<ChatDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/obtener/{id}")
    public ChatDTO obtener(@PathVariable UUID id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public ChatDTO actualizar(@PathVariable UUID id, @RequestBody ChatDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable UUID id) {
        service.eliminar(id);
    }

    // US25: Revisar historial de chats
    @GetMapping("/history")
    public List<MensajeDTO> obtenerHistorial(@RequestParam UUID chatId) {
        return service.obtenerHistorial(chatId);
    }

    // US07: Enviar Mensaje por WebSockets
    @PostMapping("/messages")
    public MensajeDTO enviarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        return service.guardarYEnviarMensaje(mensajeDTO);
    }

    @PostMapping("/emergencia/{patientId}")
    public ChatDTO solicitarChatEmergencia(@PathVariable Long patientId) {
        return service.solicitarChatEmergencia(patientId);
    }
}
