package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.RegistroDiarioDTO;
import com.upc.trabajoparcial.Entidades.RegistroDiarioEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
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
public class RegistroDiarioServicio {

    @Autowired
    private RegistroDiarioRepositorio registroDiarioRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public RegistroDiarioDTO registrar(RegistroDiarioDTO dto) {
        Long usuarioId = dto.getUsuario().getId();

        registroDiarioRepositorio.findByUsuarioIdAndFechaRegistro(usuarioId, dto.getFechaRegistro())
                .ifPresent(registro -> {
                    throw new RuntimeException("Ya existe un registro para esa fecha");
                });

        RegistroDiarioEntidad registro = modelMapper.map(dto, RegistroDiarioEntidad.class);
        registro.setUsuario(buscarUsuario(usuarioId));

        return modelMapper.map(registroDiarioRepositorio.save(registro), RegistroDiarioDTO.class);
    }

    public List<RegistroDiarioDTO> listarPorUsuario(Long usuarioId) {
        return registroDiarioRepositorio.findByUsuarioIdOrderByFechaRegistroDesc(usuarioId).stream()
                .map(registro -> modelMapper.map(registro, RegistroDiarioDTO.class))
                .collect(Collectors.toList());
    }

    public RegistroDiarioDTO obtenerDeHoy(Long usuarioId) {
        return registroDiarioRepositorio.findByUsuarioIdAndFechaRegistro(usuarioId, LocalDate.now())
                .map(registro -> modelMapper.map(registro, RegistroDiarioDTO.class))
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    @Transactional
    public RegistroDiarioDTO actualizar(Long id, RegistroDiarioDTO dto) {
        RegistroDiarioEntidad registro = registroDiarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro  no encontrado"));

        registro.setFechaRegistro(dto.getFechaRegistro());
        registro.setMinutosActivos(dto.getMinutosActivos());
        registro.setMinutosDescanso(dto.getMinutosDescanso());
        registro.setTipoEmocion(dto.getTipoEmocion());
        registro.setNotasEmocion(dto.getNotasEmocion());

        if (dto.getUsuario() != null && dto.getUsuario().getId() != null) {
            registro.setUsuario(buscarUsuario(dto.getUsuario().getId()));
        }

        return modelMapper.map(registroDiarioRepositorio.save(registro), RegistroDiarioDTO.class);
    }

    @Transactional
    public void eliminar(Long id) {
        registroDiarioRepositorio.deleteById(id);
    }

    private UsuarioEntidad buscarUsuario(Long usuarioId) {
        return usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
