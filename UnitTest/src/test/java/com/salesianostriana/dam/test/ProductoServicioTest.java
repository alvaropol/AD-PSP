package com.salesianostriana.dam.test;

import com.salesianostriana.dam.test.dto.GetProductoDto;
import com.salesianostriana.dam.test.model.Producto;
import com.salesianostriana.dam.test.repository.ProductoRepository;
import com.salesianostriana.dam.test.service.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class ProductoServicioTest {
    @Mock
    ProductoRepository repository;

    @InjectMocks
    ProductoServicio servicio;

    @Test
    void precioMenorQue10YDisponible(){

        List<Producto> data= List.of(
                new Producto(1L,"Producto 1",3,false),
                new Producto(2L,"Producto 2",9.99,true),
                new Producto(3L,"Producto 3",3,true),
                new Producto(4L,"Producto 4",9.99,true),
                new Producto(5L,"Producto 5",17,false)
        );
        //Precondiciones
        Mockito.when(repository.findAll()).thenReturn(data);

        //Test
        List<GetProductoDto> data2 = List.of(GetProductoDto.builder()
                .id(2L)
                .nombre("Producto 2")
                .build());

        List<GetProductoDto> result= servicio.precioMenorQue10YDisponible();

        Assertions.assertEquals(result,data2);

    }
}
