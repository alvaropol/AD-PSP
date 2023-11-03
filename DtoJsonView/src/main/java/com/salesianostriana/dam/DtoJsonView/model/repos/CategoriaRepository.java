package com.salesianostriana.dam.DtoJsonView.model.repos;


import com.salesianostriana.dam.DtoJsonView.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
