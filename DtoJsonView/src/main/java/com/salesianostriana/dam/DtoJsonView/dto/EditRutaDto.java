package com.salesianostriana.dam.DtoJsonView.dto;

import java.util.List;

public record EditRutaDto(
        String nombre,
        int duracion,
        String dificultad,
        List<Long> monumentos) {


}
