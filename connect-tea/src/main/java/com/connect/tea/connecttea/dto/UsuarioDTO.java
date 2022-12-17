package com.connect.tea.connecttea.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private String pass;

    private Date fechaNacimiento;
    
}
