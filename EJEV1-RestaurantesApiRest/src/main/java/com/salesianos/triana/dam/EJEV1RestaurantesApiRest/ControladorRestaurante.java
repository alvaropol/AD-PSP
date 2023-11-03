package com.salesianos.triana.dam.EJEV1RestaurantesApiRest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/place") //Para trabajar más cómodos en las rutas de las peticiones
public class ControladorRestaurante {

    //Inyectamos el repositorio de restaurante, y al no ser modificado lo añadimos con "final"
    private final RepositorioRestaurante repositorio;

    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> findAll(){
        List<Restaurante> listaRestaurantes = repositorio.findAll();

        if(listaRestaurantes.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(listaRestaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getById(@PathVariable Long id){

        return ResponseEntity.of(repositorio.findById(id));
        //Abreviación de que si lo encuentra nos devuelve el code 200 y si no lo encuentra nos devuelve el 404 (not found)
    }

    @PostMapping("/")
    public ResponseEntity<Restaurante> createRestaurant(@RequestBody Restaurante r){

        Restaurante restauranteCreado = repositorio.save(r);
        return ResponseEntity.status(201).body(restauranteCreado);
        //Devuelve 201 al crearse y como cuerpo en JSON el restaurante creado mediante POST
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> editRestaurant(@PathVariable Long id,
                                                      @RequestBody Restaurante r) {
        return ResponseEntity.of(repositorio.findById(id)
                .map(editado -> {
                    //ID no se modifica
            editado.setNombre(r.getNombre());
            editado.setDireccion(r.getDireccion());
            editado.setLatitud(r.getLatitud());
            editado.setLongitud(r.getLongitud());
            editado.setDescripcion(r.getDescripcion());
            //Los tags no se pueden cambiar, se modifican en otro PUT
            editado.setUrl(r.getUrl());

            return repositorio.save(editado);
        }));

    }

    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Restaurante> addTag(@PathVariable Long id, @PathVariable String nuevo_tag){

        Optional<Restaurante> r = repositorio.findById(id);

        if(r.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Restaurante restaurante = r.get();
            String [] tags = restaurante.getTags();

            for (String tag : tags) {
                if (nuevo_tag.equalsIgnoreCase(tag)) {
                    return ResponseEntity.status(200).build();
                } else {

                    String[] tagAdd = Arrays.copyOf(tags, tags.length + 1);
                    tagAdd[tags.length] = nuevo_tag;
                    restaurante.setTags(tagAdd);

                    repositorio.save(restaurante);
                }
            }
            return ResponseEntity.status(200).build();
        }

    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id, @PathVariable String tagABorrar){

        Optional<Restaurante> r = repositorio.findById(id);

        if(r.isEmpty()){
            return ResponseEntity.notFound().build();

        }else{
            Restaurante restaurante = r.get();
            String [] tags = restaurante.getTags();
            //Creamos otro array para ir añadiendo los demás tags que no se quieren eliminar
            String [] tagsUpdate = new String[tags.length -1 ];

            int nuevoIndice = 0; //Creamos una variable con el índice para ir sumando los elementos del array.

            for (String tag : tags) {
                if(!tagABorrar.equalsIgnoreCase(tag)){
                    tagsUpdate[nuevoIndice] = tag;
                    nuevoIndice++;
                }
            }

            restaurante.setTags(tagsUpdate);
            repositorio.save(restaurante);

            if (nuevoIndice == tags.length){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.status(200).build();
            }
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){

        if(repositorio.existsById(id))
            repositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
