package com.salesianos.triana.EjDto_Clase.repository;


import com.salesianos.triana.EjDto_Clase.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
