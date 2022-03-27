package com.example.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class PacienteController {

    // el model addaAttribute funciona solo sin la notacion @RestController, si se la dejamos va a devolver en el endpoint el index como un string en vez de direccionar al template.
//    @GetMapping("index")
//    public String testMostrar(Model model) {
//        model.addAttribute("nombre","Pablo Leonel Cristaldo");
//        return "index";
//    }

    @GetMapping("/")
    public String testMostrar2() {;
        return "Hola Mundo";
    }
}
