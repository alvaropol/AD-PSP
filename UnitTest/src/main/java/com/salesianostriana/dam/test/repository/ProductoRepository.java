package com.salesianostriana.dam.test.repository;

import com.salesianostriana.dam.test.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioLessThan(double precio);

}