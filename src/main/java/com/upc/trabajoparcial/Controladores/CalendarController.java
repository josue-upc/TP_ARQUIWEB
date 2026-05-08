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
            googleCalendarService.crearEvento(dto.getSummary(), dto.getStartTime(), dto.getEndTime());
            return ResponseEntity.ok("¡Evento creado exitosamente en Google Calendar!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al conectar con Google: " + e.getMessage());
        }
    }
}