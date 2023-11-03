package com.salesianostriana.dam.DtoJsonView.model.repos;


import com.salesianostriana.dam.DtoJsonView.model.entities.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
