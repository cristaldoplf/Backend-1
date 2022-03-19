package clinicaOdontologica;

import clinicaOdontologica.daos.OdontologoDaoH2;
import clinicaOdontologica.entidades.Odontologo;
import clinicaOdontologica.servicios.OdontologoService;

public class Main {

    public static void main(String[] args) {

        //creo los odontologos
        Odontologo odontologoUno = new Odontologo(1L, "Pablo", "Cristaldo", "AF 929421");
        Odontologo odontologoDos = new Odontologo(2L, "Leonel", "Fernandez", "AF 24824");


        //creo el service con su referencia(estrategia).
        OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIdao(odontologoDaoH2);

        //guardo en la base de datos los odontologos creados.
        odontologoService.guardar(odontologoUno);
        odontologoService.guardar(odontologoDos);

        //busco los odontologos creados por su id.
        Odontologo odonntologoBuscado1 = odontologoService.buscarOdontologo(1L);
        System.out.println("Resultado de buscar el odontologo con el id 1 : ");
        System.out.println("ID: " + odonntologoBuscado1.getId());
        System.out.println("Nombre: " + odonntologoBuscado1.getNombre());
        System.out.println("Apellido: " + odonntologoBuscado1.getApellido());
        System.out.println("Matricula: " + odonntologoBuscado1.getNumeroMatricula() + "\n");

        Odontologo odonntologoBuscado2 = odontologoService.buscarOdontologo(2L);
        System.out.println("Resultado de buscar el odontologo con el id 2 : ");
        System.out.println("ID: " + odonntologoBuscado2.getId());
        System.out.println("Nombre: " + odonntologoBuscado2.getNombre());
        System.out.println("Apellido: " + odonntologoBuscado2.getApellido());
        System.out.println("Matricula: " + odonntologoBuscado2.getNumeroMatricula() + "\n");

        //elimino odontologo en la base de datos buscandolo por su id.
        odontologoService.elimarOdontologo(1L);
        odontologoService.elimarOdontologo(2L);
        //intentamos buscar al odontologo eliminado
        odontologoService.buscarOdontologo(1L);

        //creo varios odontologos para usar el metodo buscarTodos
        Odontologo odontologTres = new Odontologo(3L, "Laura", "Vergara", "AF 124421");
        Odontologo odontologoCuatro = new Odontologo(4L, "Humberto", "Ponciano", "AF 6233");
        Odontologo odontologoCinco = new Odontologo(5L, "Rosa", "Vazquez", "AF 6233");
        odontologoService.guardar(odontologTres);
        odontologoService.guardar(odontologoCuatro);
        odontologoService.guardar(odontologoCinco);

        System.out.println(" ");
        System.out.println("Muestro por consola la lista de odontologos buscada.");
        for (Odontologo odontologo : odontologoService.buscarTodos()) {
            System.out.println(
                    "Nombre: " + odontologo.getNombre() + "\n" +
                            "Apellido: " + odontologo.getApellido() + "\n" +
                            "Matricula: " + odontologo.getNumeroMatricula()+ "\n"
            );
        }

        System.out.println(" ");
        odontologoService.elimarOdontologo(3L);
        odontologoService.elimarOdontologo(4L);
        odontologoService.elimarOdontologo(5L);


    }


}
