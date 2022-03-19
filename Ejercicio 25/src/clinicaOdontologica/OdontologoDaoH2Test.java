package clinicaOdontologica;

import clinicaOdontologica.daos.OdontologoDaoH2;
import clinicaOdontologica.entidades.Odontologo;
import clinicaOdontologica.servicios.OdontologoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class OdontologoDaoH2Test {
    //reservamos memoria para las pruebas y declaramos variables para usar en diferentes bloques de codigo.
    private static Odontologo odontologo1;
    private static Odontologo odontologo2;
    private static Odontologo odontologo3;
    private static Odontologo odontologo4;
    private static Odontologo odontologo5;
    private static List<Odontologo> list_odontologo;
    private static OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
    private static OdontologoService odontologoService = new OdontologoService();


    @BeforeAll
    public static void creacionObjetos(){
        //creamos el servicio para guardar los odontologos y despues pedir la lista.
        odontologoDaoH2 = new OdontologoDaoH2();
        odontologoService = new OdontologoService();
        odontologoService.setOdontologoIdao(odontologoDaoH2);

        //Limpiamos la base de datos antes de empezar.


        //creamos odontologos, una lista y los agregamos para compararlos posteriormente al pedir la lista en la base de datos.
        odontologo1 = new Odontologo(1L, "Pablo", "Cristaldo", "AF 929421");
        odontologo2 = new Odontologo(2L, "Leonel", "Fernandez", "AF 24824");
        odontologo3 = new Odontologo(3L, "Laura", "Vergara", "AF 124421");
        odontologo4 = new Odontologo(4L, "Humberto", "Ponciano", "AF 6233");
        odontologo5 = new Odontologo(5L, "Rosa", "Vazquez", "AF 6233");
        list_odontologo = new ArrayList<>();
        list_odontologo.add(odontologo1);
        list_odontologo.add(odontologo2);
        list_odontologo.add(odontologo3);
        list_odontologo.add(odontologo4);
        list_odontologo.add(odontologo5);



    }

    @Test
    public void testLista(){
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo3);
        odontologoService.guardar(odontologo4);
        odontologoService.guardar(odontologo5);

        assertEquals(odontologoService.buscarTodos().size(),list_odontologo.size());
        int index = 0;
        for (Odontologo o:odontologoService.buscarTodos()) {
            assertEquals(o.getId(),list_odontologo.get(index).getId());
            assertEquals(o.getNombre(),list_odontologo.get(index).getNombre());
            assertEquals(o.getApellido(),list_odontologo.get(index).getApellido());
            assertEquals(o.getNumeroMatricula(),list_odontologo.get(index).getNumeroMatricula());
            index++;
        }
        
        odontologoService.elimarOdontologo(1L);
        odontologoService.elimarOdontologo(2L);
        odontologoService.elimarOdontologo(3L);
        odontologoService.elimarOdontologo(4L);
        odontologoService.elimarOdontologo(5L);


    }
}