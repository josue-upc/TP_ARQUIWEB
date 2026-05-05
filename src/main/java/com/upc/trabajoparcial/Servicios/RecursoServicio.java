package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.RecursoDTO;
import com.upc.trabajoparcial.Entidades.RecursoEntidad;
import com.upc.trabajoparcial.Repositorios.RecursoRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecursoService {
    
    @Autowired
    private RecursoRepositorio recursoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioReporio;

    @Autowired
    private ModelMapper modelMapper;

    public RecursoDTO crear(RecursoDTO dto) {
        RecursoEntidad r = modelMapper.map(dto, RecursoEntidad.class);

        if (dto.getUploadedById() != null) {
            r.setUploadedBy(
                usuarioRepositorio.findById(dto.getUploadedById())
                    .orElseThrow(() -> new RuntimeException("Usuario no existe"))
            );
        }

        return modelMapper.map(usuarioReporio.save(r), RecursoDTO.class);
    }

    public List<RecursoDTO> listar() {
        return usuarioReporio.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RecursoDTO.class))
                .toList();
    }

    public RecursoDTO obtener(UUID id) {
        return modelMapper.map(
                usuarioReporio.findById(id).orElseThrow(),
                RecursoDTO.class
        );
    }

    public void eliminar(UUID id) {
        usuarioReporio.deleteById(id);
    }
}