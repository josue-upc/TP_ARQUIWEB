package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.UsuarioLogroDTO;
import com.upc.trabajoparcial.Entidades.UsuarioLogroEntidad;
import com.upc.trabajoparcial.Repositorios.UsuarioLogroRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioLogroServicio {

    @Autowired
    private UsuarioLogroRepositorio usuarioLogroRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public UsuarioLogroDTO crear(UsuarioLogroDTO dto) {
        UsuarioLogroEntidad entidad = modelMapper.map(dto, UsuarioLogroEntidad.class);
        entidad = usuarioLogroRepositorio.save(entidad);
        return modelMapper.map(entidad, UsuarioLogroDTO.class);
    }

    public List<UsuarioLogroDTO> listarTodos() {
        return usuarioLogroRepositorio.findAll().stream()
                .map(ul -> modelMapper.map(ul, UsuarioLogroDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminar(Long id) {
        usuarioLogroRepositorio.deleteById(id);
    }
}