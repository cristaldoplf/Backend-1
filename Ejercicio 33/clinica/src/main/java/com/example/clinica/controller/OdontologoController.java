package com.example.clinica.controller;

import com.example.clinica.repository.imp.OdontologoDaoH2;
import com.example.clinica.domain.Odontologo;
import com.example.clinica.services.imp.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OdontologoController {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());



    @GetMapping("/odontologo/buscar/{id}") //le indicamos que la url va a ser el de la variable que van a ingresar.
    public Odontologo buscar(@PathVariable Long id) { //marcamos pathvariable para saber que esa sera la variable.
        return odontologoService.buscarOdontologo(id);
    }

    @PostMapping("/odontologo/registrar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardar(odontologo);
    }

    @DeleteMapping("/odontologo/eliminar/{id}")//puede ser la misma url que mapping por que es diferente tipo de pedido (delete / get)
    public ResponseEntity eliminar(@PathVariable Long id){
        ResponseEntity response = null;

        if(odontologoService.buscarOdontologo(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.elimarOdontologo(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
}
