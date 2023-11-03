package com.salesianostriana.dam.DtoJsonView.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.DtoJsonView.model.entities.MonumentoView.*;

import java.util.List;

@Entity
@Data // Jpa Buddy
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id @GeneratedValue
    @JsonView({MonumentoDetail.class})
    private Long id;

    @JsonView({MonumentoDetail.class, MonumentoEdit.class})
    private String codigoPais, pais, ciudad,
            loc;

    @JsonView({MonumentoList.class, MonumentoEdit.class})
    private String nombre, descripcion;


    @JsonView({MonumentoDetail.class, MonumentoEdit.class})
    @ElementCollection // Obligatoria en Spring Boot 2.
    private List<String> imagenes;

    @JsonView({MonumentoDetail.class, MonumentoEdit.class})
    @ManyToOne
    private Categoria categoria;


}
