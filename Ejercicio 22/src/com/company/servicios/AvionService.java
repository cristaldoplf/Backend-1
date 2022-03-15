package com.company.servicios;
import com.company.daos.IDao;
import com.company.entidades.Avion;

import java.util.List;

public class AvionService {
    private IDao<Avion> avionIDao;

    public void setAvionIDao(IDao<Avion> avionIDao) {
        this.avionIDao = avionIDao;
    }

    public IDao<Avion> getAvionIDao() {
        return avionIDao;
    }

    public Object registrar(Avion a) {
        return avionIDao.registrar(a);
    }


    public void modificar(Long id, String marca) {
        avionIDao.modificar(id, marca);
    }


    public void darBaja(Long id) {
        avionIDao.darBaja(id);
    }


    public List<Avion> verFlota() {
        return avionIDao.verFlota();
    }
}
