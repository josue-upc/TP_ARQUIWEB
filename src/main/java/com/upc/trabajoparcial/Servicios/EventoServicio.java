package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.EventoDTO;
import com.upc.trabajoparcial.Entidades.EventoEntidad;
import com.upc.trabajoparcial.Repositorios.EventoRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private GoogleCalendarService googleCalendarService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public EventoDTO crear(EventoDTO dto) {
        // 1. Mapeo inicial y validación de existencia del usuario en la BD local
        EventoEntidad e = modelMapper.map(dto, EventoEntidad.class);
        e.setUser(
                usuarioRepositorio.findById(dto.getUserId())
                        .orElseThrow(() -> new RuntimeException("El usuario especificado no existe en el sistema"))
        );

        // Guarda localmente para obtener el ID autogenerado
        e = eventoRepositorio.save(e);

        // 2. Flujo de despacho a Google Calendar si el flag está activo
        if (dto.isSincronizarConGoogle() && dto.getEventDatetime() != null) {
            try {
                // Convierte la fecha local al estándar ISO 8601 con zona horaria UTC (Z) para Google
                String fechaInicio = dto.getEventDatetime().format(DateTimeFormatter.ISO_DATE_TIME) + "Z";
                String fechaFin = dto.getEventDatetime().plusHours(1).format(DateTimeFormatter.ISO_DATE_TIME) + "Z";

                // Invoca al servicio de la nube (que lee el credentials.json internamente)
                String googleId = googleCalendarService.crearEvento(
                        dto.getTitle(),
                        dto.getDescription(),
                        fechaInicio,
                        fechaFin
                );

                // Enlaza el ID devuelto por Google a nuestra entidad y actualizamos
                e.setGoogleEventId(googleId);
                e = eventoRepositorio.save(e);
            } catch (Exception ex) {
                // Si Google falla (ej. sin internet), evitamos hacer rollback local para no perder la cita en StayCool
                System.err.println("Advertencia: Evento guardado localmente, pero falló la sincronización remota: " + ex.getMessage());
            }
        }

        return modelMapper.map(e, EventoDTO.class);
    }

    public List<EventoDTO> listar() {
        return eventoRepositorio.findAll().stream()
                .map(e -> modelMapper.map(e, EventoDTO.class)).toList();
    }

    public EventoDTO obtener(Long id) {
        return modelMapper.map(eventoRepositorio.findById(id).orElseThrow(), EventoDTO.class);
    }

    public void eliminar(Long id) {
        eventoRepositorio.deleteById(id);
    }
}