package com.example.clinica.services;

import com.example.clinica.daos.IDao;
import com.example.clinica.domain.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public IDao<Paciente> getPacienteIDao() {
        return pacienteIDao;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente o) {
        return pacienteIDao.guardar(o);
    }

    public void elimar(Long id) {
        pacienteIDao.eliminar(id);
    }

    public Paciente buscar(Long id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }
}
