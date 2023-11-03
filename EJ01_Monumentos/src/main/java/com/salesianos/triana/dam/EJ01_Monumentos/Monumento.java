package com.salesianos.triana.dam.EJ01_Monumentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais,nombrePais,nombreCiudad,
            latitud,longitud,nombreMonumento,descripcionMonumento, url;




}
