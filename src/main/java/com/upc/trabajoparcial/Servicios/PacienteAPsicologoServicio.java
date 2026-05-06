package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.AlertaDTO;
import com.upc.trabajoparcial.DTOs.PacienteAPsicologoDTO;
import com.upc.trabajoparcial.DTOs.PatientMonitoreoDTO;
import com.upc.trabajoparcial.Entidades.PacientesAPsicologoEntidad;
import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
import com.upc.trabajoparcial.Repositorios.PacienteAPsicologoRepositorio;
import com.upc.trabajoparcial.Repositorios.RegistroDiarioRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteAPsicologoServicio {

    @Autowired
    private PacienteAPsicologoRepositorio pacienteAPsicologoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RegistroDiarioRepositorio registroDiarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public PacienteAPsicologoDTO asignarPaciente(PacienteAPsicologoDTO dto) {
        Long psicologoId = dto.getPsicologo().getId();
        Long pacienteId = dto.getPaciente().getId();

        if (pacienteAPsicologoRepositorio.existsByPsicologoIdAndPacienteId(psicologoId, pacienteId)) {
            throw new RuntimeException("El paciente ya se encuentra asignado al psicologo");
        }

        PacientesAPsicologoEntidad relacion = new PacientesAPsicologoEntidad();
        relacion.setPsicologo(buscarUsuario(psicologoId, "Psicologo no encontrado"));
        relacion.setPaciente(buscarUsuario(pacienteId, "Paciente no encontrado"));

        return modelMapper.map(pacienteAPsicologoRepositorio.save(relacion), PacienteAPsicologoDTO.class);
    }

    public List<PacienteAPsicologoDTO> listarPorPsicologo(Long psicologoId) {
        return pacienteAPsicologoRepositorio.findByPsicologoId(psicologoId).stream()
                .map(relacion -> modelMapper.map(relacion, PacienteAPsicologoDTO.class))
                .collect(Collectors.toList());
    }

    public List<PatientMonitoreoDTO> getMonitoring(Long psicologoId) {
        return pacienteAPsicologoRepositorio.findByPsicologoId(psicologoId).stream()
                .map(PacientesAPsicologoEntidad::getPaciente)
                .map(paciente -> new PatientMonitoreoDTO(
                        paciente.getId(),
                        paciente.getName(),
                        obtenerEstadoPaciente(paciente)
                ))
                .collect(Collectors.toList());
    }

    public List<AlertaDTO> getCriticalAlerts(Long psicologoId) {
        return pacienteAPsicologoRepositorio.findByPsicologoId(psicologoId).stream()
                .map(PacientesAPsicologoEntidad::getPaciente)
                .map(paciente -> crearAlertaCritica(psicologoId, paciente))
                .filter(alerta -> alerta != null)
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminar(Long psicologoId, Long pacienteId) {
        PacientesAPsicologoEntidad relacion = pacienteAPsicologoRepositorio
                .findByPsicologoIdAndPacienteId(psicologoId, pacienteId)
                .orElseThrow(() -> new RuntimeException("Relacion no encontrada"));

        pacienteAPsicologoRepositorio.delete(relacion);
    }

    private UsuarioEntidad buscarUsuario(Long id, String mensajeError) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException(mensajeError));
    }

    private AlertaDTO crearAlertaCritica(Long psicologoId, UsuarioEntidad paciente) {
        RegistroDiarioEntidad registro = obtenerRegistroDeHoy(paciente);

        if (registro == null || !superaMetaDiaria(paciente, registro)) {
            return null;
        }

        AlertaDTO alerta = new AlertaDTO();
        alerta.setReceptorId(psicologoId);
        alerta.setEmisorAlertaId(paciente.getId());
        alerta.setTipo("CRITICAL");
        alerta.setMensaje("El paciente supero su limite diario por "
                + (registro.getMinutosActivos() - paciente.getDailyGoalMinutes())
                + " minutos");
        alerta.setLeido(false);
        return alerta;
    }

    private String obtenerEstadoPaciente(UsuarioEntidad paciente) {
        RegistroDiarioEntidad registro = obtenerRegistroDeHoy(paciente);
        return registro != null && superaMetaDiaria(paciente, registro) ? "CRITICAL" : "STABLE";
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
