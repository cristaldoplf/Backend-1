package com.example.calcularEdad.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{anio}") //le indicamos que la url va a ser el de la variable que van a ingresar.
    public int buscar(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){ //marcamos pathvariable para saber que esa sera la variable.
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fechaACtual = LocalDate.now();
        return Period.between(fechaNacimiento,fechaACtual).getYears();
    }
}
