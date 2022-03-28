package com.example.clinica;

import com.example.clinica.daos.DomicilioDaoH2;
import com.example.clinica.daos.OdontologoDaoH2;
import com.example.clinica.daos.PacienteDaoH2;
import com.example.clinica.daos.TurnoDaoH2;
import com.example.clinica.domain.Domicilio;
import com.example.clinica.domain.Odontologo;
import com.example.clinica.domain.Paciente;
import com.example.clinica.services.DomicilioService;
import com.example.clinica.services.OdontologoService;
import com.example.clinica.services.PacienteService;
import com.example.clinica.services.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClinicaApplication.class, args);


        try {
            //creo los servicios
            OdontologoService odontologoService = new OdontologoService();
            OdontologoDaoH2 odontologoServiceDaoH2 = new OdontologoDaoH2();
            odontologoService.setOdontologoIdao(odontologoServiceDaoH2);

//            PacienteService pacienteService = new PacienteService();
//            PacienteDaoH2 pacienteServiceDaoH2 = new PacienteDaoH2();
//            pacienteService.setPacienteIDao(pacienteServiceDaoH2);
//
//            TurnoService turnoService = new TurnoService();
//            TurnoDaoH2 turnoServiceDaoH2 = new TurnoDaoH2();
//            turnoService.setTurnoIdao(turnoServiceDaoH2);

            //creamos los odontologos1
            Odontologo odontologo1 = new Odontologo("Cristaldo","Pablo","asd123");
            odontologoService.guardar(odontologo1);

            //creamos un domicilio para cada paciente, el id del domicilio como propiedad del paciente es agregado en el metodo guardar del h2 correspondiente
            //ya que ese id se genera de forma automatica por la base de datos.
//            Domicilio domicilio1 = new Domicilio("Avenida Siempre viva","1234","Springfield","Oregon");
//            Paciente paciente1 = new Paciente("Fernandez","Leonel","Fernandez@gmail.com",11111111,new Date());
//            paciente1.setDomicilio(domicilio1);
//            paciente1.setOdontologo(odontologo1);
//            paciente1.setOndotologoId(odontologo1.getId());
//
//            pacienteService.guardar(paciente1);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
