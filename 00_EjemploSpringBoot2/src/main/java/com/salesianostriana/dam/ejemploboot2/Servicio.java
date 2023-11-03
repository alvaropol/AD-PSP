package com.salesianostriana.dam.ejemploboot2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Servicio {

    private final Componente componente;
    private final Componente2 componente2;

    public void run(){
        componente.print();
        componente2.print();
    }
}
