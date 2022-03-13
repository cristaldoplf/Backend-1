package Felinos;
import org.apache.log4j.Logger;

public class Leon {
    private static final Logger logger = Logger.getLogger(Main.class);
    private String nombre;
    private int edad;
    private boolean esAlfa;

    public Leon(String nombre, int edad, boolean esAlfa) throws Exception {
        if (edad < 0){
            logger.error("El leon no puede tener un valor de edad negativo");
            throw new Exception("El leon no puede tener un valor de edad negativo");
        }else {
            this.nombre = nombre;
            this.edad = edad;
            this.esAlfa = esAlfa;
        }


    }

    public void correr(){
        logger.info("El leon "+nombre+" esta corriendo");
    }

    public void esMayor(){
        if (edad >10 && esAlfa == true){
            logger.info("El leon "+nombre+" esta viejo y es alfa.");
        }else {
            logger.info("El leon "+nombre+" es joven, no es alfa, o ambas condiciones a la vez.");
        }
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

    public boolean isEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(boolean esAlfa) {
        this.esAlfa = esAlfa;
    }
}
