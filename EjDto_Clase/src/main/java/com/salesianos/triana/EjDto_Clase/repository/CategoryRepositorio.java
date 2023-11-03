package com.salesianos.triana.EjDto_Clase.repository;

import com.salesianos.triana.EjDto_Clase.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositorio extends JpaRepository<Category, Long> {
}
