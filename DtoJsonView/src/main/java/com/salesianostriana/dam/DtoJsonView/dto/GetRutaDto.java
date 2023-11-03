package com.salesianostriana.dam.DtoJsonView.dto;



import com.salesianostriana.dam.DtoJsonView.model.entities.Ruta;

import java.util.List;

public record GetRutaDto(
        Long id,
        String nombre,
        String dificultad,
        String tiempo,
        List<GetMonumentoEnRutaDto> monumentos
) {

    public static GetRutaDto of (Ruta r)  {

        return new GetRutaDto(
                r.getId(),
                r.getNombre(),
                r.getDificultad().name(),
                Integer.toString(r.getTiempo()),
                r.getMonumentos()
                        .stream()
                        .map(GetMonumentoEnRutaDto::of)
                        .toList()
        );


    }


}
