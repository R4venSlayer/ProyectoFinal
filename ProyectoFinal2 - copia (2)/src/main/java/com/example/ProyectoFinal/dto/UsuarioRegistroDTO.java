package com.example.ProyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistroDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String b_date;

    public UsuarioRegistroDTO(Long id, String first_name, String last_name, String username, String password, String b_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.b_date = b_date;
    }

    public UsuarioRegistroDTO(String first_name, String last_name, String username, String password, String b_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.b_date = b_date;
    }

    public UsuarioRegistroDTO(String username) {
        this.username = username;
    }

    public UsuarioRegistroDTO() {
    }
}
