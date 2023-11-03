package com.salesianostriana.dam._EjemploSpringBoot3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class MainController {

    @GetMapping("/index/")
    public String index(Model model) {

        model.addAttribute("mensaje","hola mellamo");

        return "index";
    }
}
