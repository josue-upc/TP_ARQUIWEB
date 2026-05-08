package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.PsicologoDashboardDTO;
import com.upc.trabajoparcial.Servicios.PsicologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/psychologist")
public class PsicologoControlador {
    @Autowired
    private PsicologoServicio servicio;

    // US32: Panel de indicadores clínicos
    @GetMapping("/dashboard/metrics")
    public PsicologoDashboardDTO obtenerMetricasDashboard(@RequestParam Long psicologoId) {
        return servicio.obtenerMetricasDashboard(psicologoId);
    }

    // US10: GET /api/v1/psychologist/patients/monitoring
    @GetMapping("/patients/monitoring")
    public java.util.List<com.upc.trabajoparcial.DTOs.PatientMonitoreoDTO> monitorearPacientes(@RequestParam Long psicologoId) {
        return servicio.monitorearPacientes(psicologoId);
    }
}
