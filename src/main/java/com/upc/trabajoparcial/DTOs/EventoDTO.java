package com.upc.trabajoparcial.DTOs;

import com.upc.trabajoparcial.Entidades.EventoType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {
    private Long id;
    private Long userId;
    private EventoType type; // Ej: CALENDAR_MEETING, PERSONAL_REMINDER
    private String title;
    private String description;
    private LocalDateTime eventDatetime; // Formato esperado: "2026-05-15T18:30:00"
    private Boolean isRecurring;
    private String googleEventId;

    //FLAG CLAVE: Si viene en true, el servicio orquestador lo mandará a la nube de Google
    private boolean sincronizarConGoogle;
}