package com.company;

import com.company.daos.EstudianteDAOH2;
import com.company.entidades.Estudiante;
import com.company.servicios.EstudianteService;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L);
        estudiante.setNombre("pablo");
        estudiante.setApellido("cristaldo");

        EstudianteService estudianteService = new EstudianteService();
        //seteamos una estrategia de persistencia, es decir un DAO.
        estudianteService.setEstudianteServiceIDao(new EstudianteDAOH2());

        estudianteService.guardarEstudiante(estudiante);
        estudianteService.eliminarEstudiante(estudiante.getId());

    }
}
