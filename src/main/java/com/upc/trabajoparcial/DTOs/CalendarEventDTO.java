package com.upc.trabajoparcial.Dtos;

import lombok.Data;

@Data
public class CalendarEventDTO {
    private String summary;    // Título de la reunión
    private String startTime;  // Formato: 2026-05-10T10:00:00Z
    private String endTime;    // Formato: 2026-05-10T11:00:00Z
}