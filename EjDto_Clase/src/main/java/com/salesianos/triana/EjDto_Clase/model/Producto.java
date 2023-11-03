package com.salesianos.triana.EjDto_Clase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, desc;
    private double pvp;
    private List<String> images;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
