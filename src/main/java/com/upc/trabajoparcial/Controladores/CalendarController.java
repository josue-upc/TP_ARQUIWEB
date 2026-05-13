package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.Dtos.CalendarEventDTO;
import com.upc.trabajoparcial.Servicios.GoogleCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calendar")
public class CalendarController {

    @Autowired
    private GoogleCalendarService googleCalendarService;

    @PostMapping("/event")
    public ResponseEntity<String> createEvent(@RequestBody CalendarEventDTO dto) {
        try {
            // Añadimos un cuarto parámetro (descripción por defecto) para cumplir con la firma del servicio
            String googleEventId = googleCalendarService.crearEvento(
                    dto.getSummary(),
                    "Evento de prueba agendado directamente desde el endpoint simple.",
                    dto.getStartTime(),
                    dto.getEndTime()
            );
            return ResponseEntity.ok("¡Evento creado exitosamente en Google Calendar con ID: " + googleEventId + "!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al conectar con Google: " + e.getMessage());
        }
    }
}