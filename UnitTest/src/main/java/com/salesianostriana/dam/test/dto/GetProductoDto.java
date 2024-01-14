package com.salesianostriana.dam.test.dto;

import com.salesianostriana.dam.test.model.Producto;
import lombok.Builder;

@Builder
public record GetProductoDto(

        Long id, String nombre, double precio
) {

    public static GetProductoDto of(Producto p){
        return new GetProductoDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio()
        );
    }
}
