package com.upc.trabajoparcial.Controladores;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.DTOs.PacienteAPsicologoDTO;
import com.upc.trabajoparcial.DTOs.PatientMonitoreoDTO;
import com.upc.trabajoparcial.Servicios.PacienteAPsicologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes-psicologo")
public class PacienteaPsicologoControlador {

    @Autowired
    private PacienteAPsicologoServicio pacienteAPsicologoServicio;

    @PostMapping("/asignar")
    public PacienteAPsicologoDTO asignarPaciente(@RequestBody PacienteAPsicologoDTO dto) {
        return pacienteAPsicologoServicio.asignarPaciente(dto);
    }

    @GetMapping("/listar/{psicologoId}")
    public List<PacienteAPsicologoDTO> listarPorPsicologo(@PathVariable Long psicologoId) {
        return pacienteAPsicologoServicio.listarPorPsicologo(psicologoId);
    }

    @GetMapping("/monitoreo/{psicologoId}")
    public List<PatientMonitoreoDTO> monitorearPacientes(@PathVariable Long psicologoId) {
        return pacienteAPsicologoServicio.getMonitoring(psicologoId);
    }

    @GetMapping("/alertas-criticas/{psicologoId}")
    public List<AlertaDTO> listarAlertasCriticas(@PathVariable Long psicologoId) {
        return pacienteAPsicologoServicio.getCriticalAlerts(psicologoId);
    }

    @DeleteMapping("/eliminar/{psicologoId}/{pacienteId}")
    public void eliminar(@PathVariable Long psicologoId, @PathVariable Long pacienteId) {
        pacienteAPsicologoServicio.eliminar(psicologoId, pacienteId);
    }
}
