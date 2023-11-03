package com.salesianostriana.dam.DtoJsonView.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.DtoJsonView.model.entities.RutaView.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id @GeneratedValue
    @JsonView({RutaDetail.class})
    private Long id;

    @JsonView({RutaList.class, RutaEdit.class})
    private String nombre;

    @JsonView({RutaList.class, RutaEdit.class})
    private int tiempo; // en minutos

    @Enumerated(EnumType.STRING)
    @JsonView({RutaList.class, RutaEdit.class})
    private Dificultad dificultad;

    @JsonView({RutaList.class})
    @ManyToMany
    private List<Monumento> monumentos;

}
