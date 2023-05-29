package com.proyecto.ed.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Boolean estado;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     private List<Casa> casas;
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Comment> comment;


    public User() {
    }


}