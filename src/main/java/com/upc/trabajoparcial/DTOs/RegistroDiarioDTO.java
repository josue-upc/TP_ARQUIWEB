package com.upc.trabajoparcial.DTOs;

import com.upc.trabajoparcial.Entidades.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDiarioDTO {
    private Long id;
    private UsuarioDTO usuario;

    // Nombres exactos a la Entidad para que ModelMapper funcione
    private EmotionType tipoEmocion;
    private String notasEmocion;
    private LocalDate fechaRegistro;

    // Agregamos estos para que las estadísticas funcionen luego
    private Integer minutosActivos;
    private Integer minutosDescanso;
}