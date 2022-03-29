package com.example.clinica.controller;

import com.example.clinica.daos.PacienteDaoH2;
import com.example.clinica.domain.Paciente;
import com.example.clinica.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;


@RestController
public class PacienteController {

    // el model addaAttribute funciona solo sin la notacion @RestController, si se la dejamos va a devolver en el endpoint el index como un string en vez de direccionar al template.
//    @GetMapping("index")
//    public String testMostrar(Model model) {
//        model.addAttribute("nombre","Pablo Leonel Cristaldo");
//        return "index";
//    }

    PacienteService pacienteService = new PacienteService(new PacienteDaoH2());


    @GetMapping("/")
    public String testMostrar2() {
        return "Para buscar un paciente por su id usar la siguiente ruta ||  /paciente/{id}";
    }

    @GetMapping("/buscar/paciente/{id}") //le indicamos que la url va a ser el de la variable que van a ingresar.
    public Paciente buscar(@PathVariable Long id) { //marcamos pathvariable para saber que esa sera la variable.
        return pacienteService.buscar(id);
    }

    @PostMapping("/registrar/paciente")
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }


}
