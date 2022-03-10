package Felinos;

import org.apache.log4j.Logger;

public class Tigre {
    private static final Logger logger = Logger.getLogger(Main.class);
    private String nombre;
    private int edad;

    public Tigre(String nombre, int edad) throws Exception {
        if (edad < 0){
            logger.error("El leon no puede tener un valor de edad negativo");
            throw new Exception("El leon no puede tener un valor de edad negativo");
        }else {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    public void correr(){
        logger.info("El Tigre "+nombre+" esta corriendo");
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
