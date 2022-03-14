package com.company.servicios;

import com.company.daos.IDao;
import com.company.entidades.Estudiante;

import java.util.List;

public class EstudianteService {
    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteServiceIDao() {
        return estudianteIDao;
    }

    public void setEstudianteServiceIDao(IDao<Estudiante> estudianteServiceIDao) {
        this.estudianteIDao = estudianteServiceIDao;
    }

    //Delegamos las 4 responsabilidades al DAO
    public Estudiante guardarEstudiante(Estudiante e) {
        estudianteIDao.guardar(e);
        return null;
    }

    public void eliminarEstudiante(Long id) {
        estudianteIDao.eliminar(id);
    }

    public Estudiante buscarEstudiante(Long id) {
        return estudianteIDao.buscar(id);
    }

    public List<Estudiante> buscarTodos() {
        return estudianteIDao.buscarTodos();
    }
}
