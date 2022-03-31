package com.example.MVCMapping.controller;

import com.example.MVCMapping.daos.Imp.EstudianteDAOH2;
import com.example.MVCMapping.entidades.Estudiante;
import com.example.MVCMapping.servicios.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstudianteController {

    private EstudianteService estudianteService = new EstudianteService(new EstudianteDAOH2());

    //el metodo guardar va a esperar una peticion Post
    @PostMapping("/registrar") //definimos la url para llegar al metodo.
    public Estudiante guardar(@RequestBody Estudiante estudiante){ //en un metodo Post, la informacion a guardar esta en el body y lo marcamos con un @RequestBody
        return estudianteService.guardarEstudiante(estudiante);
    }
    //este metodo me tiraba error por el content type del postman, agregar application/json yno el default de text/plain

    //el metodo buscar va a esperar una peticion Get
    @GetMapping("/{id}") //le indicamos que la url va a ser el de la variable que van a ingresar.
    public Estudiante buscar(@PathVariable int id){ //marcamos pathvariable para saber que esa sera la variable.
        return estudianteService.buscarEstudiante(id);
    }

    @DeleteMapping("/{id}")//puede ser la misma url que mapping por que es diferente tipo de pedido (delete / get)
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity response = null;

        if(estudianteService.buscarEstudiante(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            estudianteService.eliminarEstudiante(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante){
        ResponseEntity response = null;

        if(estudianteService.buscarEstudiante(estudiante.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(estudianteService.update(estudiante),HttpStatus.OK);
        }
        return response;
    }

}
