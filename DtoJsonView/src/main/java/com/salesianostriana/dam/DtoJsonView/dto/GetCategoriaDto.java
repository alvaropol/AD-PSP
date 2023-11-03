package com.salesianostriana.dam.DtoJsonView.dto;


import com.salesianostriana.dam.DtoJsonView.model.entities.Categoria;

public record GetCategoriaDto(Long id, String nombreCategoria) {


    public static GetCategoriaDto of (Categoria c) {
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }


}
