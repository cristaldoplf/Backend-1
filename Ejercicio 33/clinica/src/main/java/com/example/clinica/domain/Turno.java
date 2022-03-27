package com.example.clinica.domain;

import java.util.Date;

public class Turno {
    private Long id;
    private Date fecha;
    private Odontologo odontologo;
    private Paciente paciente;
    //tanto el id de odontologo y paciente son requeridos para guardarlos en la base de datos como referencia
    //antes de guardar el turno en la base de datos, setear estos id con el metodo set.
    //no los pongo en el constructor por que los ids tanto de odontologo como paciente son
    //generados automaticamente por la base de datos y quiza los cree en java pero aun no los guarde en la base de datos al
    //momento de poner las referencias en un objeto instanciado de la clase turno.
    private Long odontologoId;
    private Long pacienteId;


    public Turno( Date fecha) {
        this.fecha = fecha;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }


    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
