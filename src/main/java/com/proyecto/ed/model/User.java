package com.proyecto.ed.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_user")
    private int id;
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
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Casa> casas;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comment;


    public User() {
    }


}