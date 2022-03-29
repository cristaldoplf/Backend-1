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


    }


}
