package com.proyecto.ed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @ManyToOne()
    @JoinColumn(name =  "id_casa")
    @JsonBackReference
    private  Casa casa;

    @ManyToOne()
    @JoinColumn(name =  "id_user")
    private User user;

    public Comment() {
    }
}
