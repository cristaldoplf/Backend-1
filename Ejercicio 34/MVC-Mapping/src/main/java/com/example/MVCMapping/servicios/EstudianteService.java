package com.example.MVCMapping.servicios;


import com.example.MVCMapping.daos.IDao;
import com.example.MVCMapping.entidades.Estudiante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EstudianteService {
    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteServiceIDao() {
        return estudianteIDao;
    }

    public EstudianteService(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    public void setEstudianteServiceIDao(IDao<Estudiante> estudianteServiceIDao) {
        this.estudianteIDao = estudianteServiceIDao;
    }

    //Delegamos las 4 responsabilidades al DAO
    public Estudiante guardarEstudiante(Estudiante e) {
        return estudianteIDao.guardar(e);
    }

    public void eliminarEstudiante(int id) {
        estudianteIDao.eliminar(id);
    }

    public Estudiante buscarEstudiante(int id) {
        return estudianteIDao.buscar(id);
    }

    public List<Estudiante> buscarTodos() {
        return estudianteIDao.buscarTodos();
    }

    public Estudiante update(Estudiante estudiante) {
        return estudianteIDao.update(estudiante);


    }
}
