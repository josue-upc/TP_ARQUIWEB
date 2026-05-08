package com.upc.trabajoparcial.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PsicologoDashboardDTO {
    private Long totalPacientes;
    private Long alertasPendientes;
}
