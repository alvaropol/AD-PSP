package com.salesianos.triana.dam.EJEV1RestaurantesApiRest;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitData {

    private final RepositorioRestaurante repo;


    @PostConstruct
    public void init(){
        //Restaurante.builder();
    }
}
