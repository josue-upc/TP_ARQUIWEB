package com.upc.trabajoparcial.DTOs;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MensajeDTO {

    private UUID id;
    private ChatDTO chat;
    private UsuarioDTO sender;
    private String content;
    private LocalDateTime timestamp;
}
