package com.salesianostriana.dam.DtoJsonView.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.DtoJsonView.model.entities.CategoriaView.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id @GeneratedValue
    @JsonView({CategoriaDetail.class})
    private Long id;

    @JsonView({CategoriaList.class, CategoriaEdit.class})
    private String nombre;
}
