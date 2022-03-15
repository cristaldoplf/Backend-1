package com.company;

import com.company.daos.AvionDaoH2;
import com.company.entidades.Avion;
import com.company.servicios.AvionService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Avion avion = new Avion();
        avion.setId(1L);
        avion.setMarca("Rollce Royce");
        avion.setModelo("Modelo numero 1");
        avion.setMatricula("111AAA");


        AvionService avionService = new AvionService();
        avionService.setAvionIDao(new AvionDaoH2());

        avionService.registrar(avion);

    }
}
