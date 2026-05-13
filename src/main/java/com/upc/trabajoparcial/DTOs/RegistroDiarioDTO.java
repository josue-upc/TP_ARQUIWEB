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
    private EmotionType emotion;
    private String note;
    private LocalDate date;
}