package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.PsicologoDashboardDTO;
import com.upc.trabajoparcial.Servicios.PsicologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.upc.trabajoparcial.Servicios.PdfServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/psychologist")
public class PsicologoControlador {
    @Autowired
    private PsicologoServicio servicio;

    @Autowired
    private PdfServicio pdfServicio;

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

    // US12: Exportar información del paciente
    @PostMapping("/patients/export/pdf")
    public ResponseEntity<byte[]> exportarPdfPacientes() {

        byte[] pdf = pdfServicio.generarPdfPacientes();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=pacientes.pdf"
                )
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
