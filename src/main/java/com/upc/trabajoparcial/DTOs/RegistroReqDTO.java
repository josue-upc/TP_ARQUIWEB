package com.upc.trabajoparcial.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegistroReqDTO {
    private String name;
    private String email;
    private String password;
    private Long rolId;
}