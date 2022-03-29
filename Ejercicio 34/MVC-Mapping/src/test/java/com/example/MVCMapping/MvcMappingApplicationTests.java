package com.example.MVCMapping;

import com.example.MVCMapping.daos.Imp.EstudianteDAOH2;
import com.example.MVCMapping.entidades.Estudiante;
import com.example.MVCMapping.servicios.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MvcMappingApplicationTests {

	@Test
	void contextLoads() {
		Estudiante estudiante = new Estudiante(3,"Pablo","Cristaldo");

		EstudianteService estudianteService = new EstudianteService(new EstudianteDAOH2());
		//seteamos una estrategia de persistencia, es decir un DAO.


		estudianteService.guardarEstudiante(estudiante);

		
	}

}
