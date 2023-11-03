package com.salesianos.triana.dam.EJEV1RestaurantesApiRest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre, direccion,descripcion,url;
    private String[] tags;
    private double latitud,longitud;
}
