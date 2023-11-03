package com.salesianos.triana.dam.EJ01_Monumentos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorMonumento {

    private final MonumentoRepositorio repositorioMonumento;

    @GetMapping("/monumentos/")
    public ResponseEntity<List<Monumento>> findAll(){
        List<Monumento> result = repositorioMonumento.findAll();

        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/monumentos/{id}")
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return ResponseEntity.of(repositorioMonumento.findById(id));
    }

    @PostMapping("/monumentos/")
    public ResponseEntity<Monumento> createMonument(@RequestBody Monumento m){
        Monumento mNew = repositorioMonumento.save(m);
        return ResponseEntity.status(201).body(mNew);

    }

    @PutMapping("/monumentos/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id,
                                          @RequestBody Monumento m){
        return ResponseEntity.of(repositorioMonumento.findById(id)
                .map(anterior -> {
                        anterior.setCodigoPais(m.getCodigoPais());
                        anterior.setNombrePais(m.getNombrePais());
                        anterior.setNombreCiudad(m.getNombreCiudad());
                        anterior.setLatitud(m.getLatitud());
                        anterior.setLongitud(m.getLongitud());
                        anterior.setNombreMonumento(m.getNombreMonumento());
                        anterior.setDescripcionMonumento(m.getDescripcionMonumento());
                        anterior.setUrl(m.getUrl());
                        return repositorioMonumento.save(anterior);
                        }));

    }

    @DeleteMapping("/monumentos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(repositorioMonumento.existsById(id))
            repositorioMonumento.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
