package com.proyecto.ed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "casas")


public class Casa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "casa_id")
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
    @ManyToOne()
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User usuario ;
    @OneToMany(mappedBy = "casa",cascade = CascadeType.ALL)
    private List<Comment> comments;


    public Casa() {
    }

    public Casa(int id, String name, String descripcion, String tipoVenta, String ciudad, String pais, String img, String video, String estrato, String piso, String habitaciones, String area, String parqueadero, String balcon, String antiguedad, User usuario, List<Comment> comments) {
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
        this.usuario = usuario;
//        this.comments = comments;
    }
}