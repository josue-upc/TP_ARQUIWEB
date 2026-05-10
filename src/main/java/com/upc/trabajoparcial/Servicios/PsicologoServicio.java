package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.DTOs.PsicologoDashboardDTO;
import com.upc.trabajoparcial.Entidades.PacienteAPsicologoEntidad;
import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
import com.upc.trabajoparcial.Repositorios.AlertaRepositorio;
import com.upc.trabajoparcial.Repositorios.PacienteAPsicologoRepositorio;
import com.upc.trabajoparcial.Repositorios.RegistroDiarioRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class PsicologoServicio {
    @Autowired
    private PacienteAPsicologoRepositorio pacienteRepositorio;

    @Autowired
    private AlertaRepositorio alertaRepositorio;

    @Autowired
    private RegistroDiarioRepositorio registroDiarioRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void asignarPaciente(Long psicologoId, Long pacienteId) {
        var psicologo = usuarioRepositorio.findById(psicologoId).orElseThrow();
        var paciente = usuarioRepositorio.findById(pacienteId).orElseThrow();
        PacienteAPsicologoEntidad relacion = new PacienteAPsicologoEntidad();
        relacion.setPsicologo(psicologo);
        relacion.setPaciente(paciente);
        pacienteRepositorio.save(relacion);
    }
    // US32: Lógica del panel de indicadores
    public PsicologoDashboardDTO obtenerMetricasDashboard(Long psicologoId) {
        Long totalPacientes = pacienteRepositorio.countPacientesByPsicologoId(psicologoId);

        // Cuenta alertas no leídas. Si te sale error aquí, asegúrate de haber puesto
        // el código del paso 2 en tu AlertaRepositorio
        Long alertasPendientes = alertaRepositorio.countAlertasNoLeidasPorReceptor(psicologoId);

        return new PsicologoDashboardDTO(totalPacientes != null ? totalPacientes : 0L,
                alertasPendientes != null ? alertasPendientes : 0L);
    }

    public List<AlertaDTO> getCriticalAlerts(Long psicologoId) {
        return pacienteRepositorio.findByPsicologoId(psicologoId).stream()
                .map(PacienteAPsicologoEntidad::getPaciente)
                .map(this::crearAlertaCritica)
                .filter(alerta -> alerta != null)
                .collect(Collectors.toList());
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

    private AlertaDTO crearAlertaCritica(UsuarioEntidad paciente) {
        RegistroDiarioEntidad registro = obtenerRegistroDeHoy(paciente);

        if (registro == null || !superaMetaDiaria(paciente, registro)) {
            return null;
        }

        AlertaDTO alerta = new AlertaDTO();
        alerta.setPatientId(paciente.getId());
        alerta.setAlertLevel("CRITICAL");
        alerta.setExcessMinutes(registro.getMinutosActivos() - paciente.getDailyGoalMinutes());
        return alerta;
    }
    private RegistroDiarioEntidad obtenerRegistroDeHoy(UsuarioEntidad paciente) {
        return registroDiarioRepositorio
                .findByUsuarioIdAndFechaRegistro(paciente.getId(), LocalDate.now())
                .orElse(null);
    }

    private boolean superaMetaDiaria(UsuarioEntidad paciente, RegistroDiarioEntidad registro) {
        return paciente.getDailyGoalMinutes() != null
                && registro.getMinutosActivos() != null
                && registro.getMinutosActivos() > paciente.getDailyGoalMinutes();
    }
}
