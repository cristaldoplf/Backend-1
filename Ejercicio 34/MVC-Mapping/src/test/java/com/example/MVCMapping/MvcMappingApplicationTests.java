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
		Estudiante estudiante = new Estudiante(3,"Leonel","Fernandez");

		EstudianteService estudianteService = new EstudianteService(new EstudianteDAOH2());
		estudianteService.eliminarEstudiante(3);


//		estudianteService.guardarEstudiante(estudiante);

		
	}

}
