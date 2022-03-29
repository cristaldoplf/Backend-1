package com.example.clinica;

import com.example.clinica.daos.OdontologoDaoH2;
import com.example.clinica.daos.PacienteDaoH2;
import com.example.clinica.daos.TurnoDaoH2;
import com.example.clinica.domain.Domicilio;
import com.example.clinica.domain.Odontologo;
import com.example.clinica.domain.Paciente;
import com.example.clinica.domain.Turno;
import com.example.clinica.services.OdontologoService;
import com.example.clinica.services.PacienteService;
import com.example.clinica.services.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ClinicaApplicationTests {

	@Test
	void contextLoads() {
		try {
			//creo los servicios
			OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

            PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

            TurnoService turnoService = new TurnoService(new TurnoDaoH2());

			//creamos los odontologos1
			Odontologo odontologo1 = new Odontologo("Cristaldo","Pablo","asd123");
			odontologoService.guardar(odontologo1);

			//creamos un domicilio para cada paciente, el id del domicilio como propiedad del paciente es agregado en el metodo guardar del h2 correspondiente
			//ya que ese id se genera de forma automatica por la base de datos.
            Domicilio domicilio1 = new Domicilio("Avenida Siempre viva","1234","Springfield","Oregon");
            Paciente paciente1 = new Paciente("Sarasa","Leonel","Fernandez@gmail.com",11111111,new Date());
            paciente1.setDomicilio(domicilio1);
            paciente1.setOdontologo(odontologo1);
            paciente1.setOndotologoId(odontologo1.getId());
            pacienteService.guardar(paciente1);


			Turno turno1 = new Turno(new Date());
			turno1.setOdontologo(odontologo1);
			turno1.setPaciente(paciente1);

			turnoService.guardar(turno1);
			System.out.println(turnoService.buscar(1L));


		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	}




