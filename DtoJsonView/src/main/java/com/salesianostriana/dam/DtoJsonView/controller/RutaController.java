package com.salesianostriana.dam.DtoJsonView.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.DtoJsonView.dto.EditRutaDto;
import com.salesianostriana.dam.DtoJsonView.dto.GetRutaDto;
import com.salesianostriana.dam.DtoJsonView.model.entities.Ruta;
import com.salesianostriana.dam.DtoJsonView.model.entities.RutaView;
import com.salesianostriana.dam.DtoJsonView.model.repos.RutaRepository;
import com.salesianostriana.dam.DtoJsonView.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {

    private final RutaRepository rutaRepository;

    private final RutaService rutaService;

    @GetMapping("/")
    @JsonView(RutaView.RutaList.class)
    public ResponseEntity<List<GetRutaDto>> todas() {

        List<Ruta> rutas = rutaRepository.findAll();

        if (rutas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                rutas.stream()
                        .map(GetRutaDto::of)
                        .toList()
        );

    }

    @PostMapping("/")
    @JsonView(RutaView.RutaEdit.class)
    public ResponseEntity<GetRutaDto> nuevaRuta(
            @RequestBody EditRutaDto nuevo) {

        Ruta ruta = rutaService.save(nuevo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GetRutaDto.of(ruta));

    }

}