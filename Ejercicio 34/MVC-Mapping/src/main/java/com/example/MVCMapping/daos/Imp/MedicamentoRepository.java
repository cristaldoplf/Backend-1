package com.example.MVCMapping.daos.Imp;

import com.example.MVCMapping.daos.IDao;
import com.example.MVCMapping.dto.EstudianteDTO;
import com.example.MVCMapping.util.Jsons;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.util.List;

public class MedicamentoRepository implements IDao<EstudianteDTO> {
    @Override
    public EstudianteDTO guardar(EstudianteDTO estudianteDTO) {
        HttpResponse<String> response = null;
        EstudianteDTO estudiante = null;
        try{
            response = Unirest.post("http://localhost:8080/registrar")
                    .body(Jsons.asJsonString(estudianteDTO)).asString();

            estudiante = Jsons.objectFromString(EstudianteDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void eliminar(int id) {
        HttpResponse<String> response = null;

        try{
            response = Unirest.delete("http://localhost:8080/"+id).asString())
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EstudianteDTO buscar(int id) {
        HttpResponse<String> response = null;
        EstudianteDTO estudiante = null;
        try{
            response = Unirest.get("http://localhost:8080/"+id).asString();

            estudiante = Jsons.objectFromString(EstudianteDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<EstudianteDTO> buscarTodos() {
        return null;
    }

    @Override
    public EstudianteDTO update(EstudianteDTO estudianteDTO) {
        HttpResponse<String> response = null;
        EstudianteDTO estudiante = null;
        try{
            response = Unirest.put("http://localhost:8080/actualizar")
                    .body(Jsons.asJsonString(estudianteDTO)).asString();

            estudiante = Jsons.objectFromString(EstudianteDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return estudiante;
    }
}
