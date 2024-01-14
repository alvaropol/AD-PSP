package com.salesianostriana.dam.test.service;

import com.salesianostriana.dam.test.dto.GetProductoDto;
import com.salesianostriana.dam.test.model.Producto;
import com.salesianostriana.dam.test.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio {

    private ProductoRepository repo;

    public Producto save(Producto p){
        return repo.save(p);
    }
    public List<Producto> findAll(){
        return repo.findAll();
    }

    public List<Producto> saveAll(List<Producto> productos){
        return repo.saveAll(productos);
    }

    public List<Producto> productosPrecioMenor10(){
        return repo.findByPrecioLessThan(10);
    }

    public List<GetProductoDto> precioMenorQue10YDisponible(){

        List<Producto> todos= repo.findAll();
        List<GetProductoDto> result = new ArrayList<>();

        for(Producto p: todos){
            if(p.getPrecio()<10){
                if(p.isDisponible()){
                    result.add(GetProductoDto.of(p));
                }
            }
        }
        if (result.isEmpty())
            return null;
        else return result;
    }

}
