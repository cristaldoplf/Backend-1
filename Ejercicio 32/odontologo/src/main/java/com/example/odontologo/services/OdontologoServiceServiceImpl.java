package com.example.odontologo.services;

import com.example.odontologo.domain.Odontologo;
import org.springframework.stereotype.Service;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoServiceServiceImpl implements OdontologoService{
    @Override
    public List<Odontologo> list_odontologo() {
        ArrayList<Odontologo> list =  new ArrayList();
        list.add(new Odontologo("Pablo"));
        list.add(new Odontologo("Leonel"));
        list.add(new Odontologo("Cristaldo"));
        return list;
    }
}
