package com.salesianostriana.dam.DtoJsonView.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.DtoJsonView.dto.GetMonumentoDetailsDto;
import com.salesianostriana.dam.DtoJsonView.dto.GetMonumentoDto;
import com.salesianostriana.dam.DtoJsonView.model.entities.Monumento;
import com.salesianostriana.dam.DtoJsonView.model.entities.MonumentoView;
import com.salesianostriana.dam.DtoJsonView.model.repos.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/")
    @JsonView(MonumentoView.MonumentoList.class)
    public ResponseEntity<List<GetMonumentoDto>> todos() {

        List<Monumento> data = monumentoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();

        // Aquí hacemos la transformación de Monumento -> GetMonumentoDto
        List<GetMonumentoDto> result =
                data.stream()
                        .map(GetMonumentoDto::of)
                        .toList();

        return ResponseEntity.ok(result);

    }

    @JsonView(MonumentoView.MonumentoDetail.class)
    @GetMapping("/{id}")
    public ResponseEntity<GetMonumentoDetailsDto> porId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(GetMonumentoDetailsDto::of));
    }

}