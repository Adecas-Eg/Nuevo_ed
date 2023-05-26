package com.proyecto.ed.dto;

import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.Comment;
import lombok.Data;

import java.util.List;

@Data

public class userDto {

    private String email;
    private String password;
    private String fecha;
    private String edad;
    private String nombre;
    private String sexo;
    private String pais;
    private String ciudad;
    private String telefono;
    private String ftPerfil;
    private String tipo_u;
    private List<Casa> casas;

    private List<Comment> comment;

    public userDto() {
    }

    public userDto(String email, String password, String fecha, String edad, String nombre, String sexo, String pais, String ciudad, String telefono, String ftPerfil, String tipo_u) {
        this.email = email;
        this.password = password;
        this.fecha = fecha;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.ftPerfil = ftPerfil;
        this.tipo_u = tipo_u;
    }
}
