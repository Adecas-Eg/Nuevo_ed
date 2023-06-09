package com.proyecto.ed.dto;

import com.proyecto.ed.model.Comment;
import com.proyecto.ed.model.User;
import lombok.Data;

import java.util.List;
@Data
public class casaDto {
    private int id;
    private String name;
    private String descripcion;
    private String tipoVenta;
    private String ciudad;
    private String pais;
    private String img;
    private String video;
    private String estrato;
    private String piso;
    private String habitaciones;
    private String area;
    private String parqueadero;
    private String balcon;
    private String antiguedad;
    private String dirrecion;
    private User usuario ;

    private List<Comment> comments;


    public casaDto() {
    }

    public casaDto(int id, String name, String descripcion, String tipoVenta, String ciudad, String pais, String img, String video, String estrato, String piso, String habitaciones, String area, String parqueadero, String balcon, String antiguedad) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.tipoVenta = tipoVenta;
        this.ciudad = ciudad;
        this.pais = pais;
        this.img = img;
        this.video = video;
        this.estrato = estrato;
        this.piso = piso;
        this.habitaciones = habitaciones;
        this.area = area;
        this.parqueadero = parqueadero;
        this.balcon = balcon;
        this.antiguedad = antiguedad;
    }
}

