package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.PsicologoDashboardDTO;
import com.upc.trabajoparcial.Repositorios.AlertaRepositorio;
import com.upc.trabajoparcial.Repositorios.PacienteAPsicologoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PsicologoServicio {
    @Autowired
    private PacienteAPsicologoRepositorio pacienteRepositorio;

    @Autowired
    private AlertaRepositorio alertaRepositorio;

    // US32: Lógica del panel de indicadores
    public PsicologoDashboardDTO obtenerMetricasDashboard(Long psicologoId) {
        Long totalPacientes = pacienteRepositorio.countPacientesByPsicologoId(psicologoId);

        // Cuenta alertas no leídas. Si te sale error aquí, asegúrate de haber puesto
        // el código del paso 2 en tu AlertaRepositorio
        Long alertasPendientes = alertaRepositorio.countAlertasNoLeidasPorReceptor(psicologoId);

        return new PsicologoDashboardDTO(totalPacientes != null ? totalPacientes : 0L,
                alertasPendientes != null ? alertasPendientes : 0L);
    }

    // US10: Monitoreo de pacientes (Armar la lista)
    public java.util.List<com.upc.trabajoparcial.DTOs.PatientMonitoreoDTO> monitorearPacientes(Long psicologoId) {
        return pacienteRepositorio.findPacientesByPsicologoId(psicologoId)
                .stream()
                .map(relacion -> new com.upc.trabajoparcial.DTOs.PatientMonitoreoDTO(
                        relacion.getPaciente().getId(),
                        relacion.getPaciente().getName(),
                        "ACTIVO" // Le ponemos ACTIVO por defecto
                ))
                .toList();
    }
}
