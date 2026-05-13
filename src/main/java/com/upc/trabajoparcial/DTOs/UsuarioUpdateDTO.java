package com.upc.trabajoparcial.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioUpdateDTO {
    private String name;
    private Integer pauseThresholdMinutes;
    private Integer dailyGoalMinutes;
}