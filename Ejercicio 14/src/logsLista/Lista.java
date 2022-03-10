package logsLista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;


public class Lista {
    private static final Logger logger = Logger.getLogger(Main.class);
    public List<Integer> number_list = new ArrayList();


    public List getNumber_list() {
        return number_list;
    }

    public void setNumber_list(List number_list) {
        this.number_list = number_list;
    }

    public void calcularMinimo() throws Exception {
        if (this.checkErrores()) {
        } else {
            logger.info("El numero con menor valor de la lista es: "+Collections.min(number_list));
        }
    }

    public void calcularMaximo() throws Exception {
        if (this.checkErrores()) {
        } else {
            logger.info("El numero con mayor valor de la lista es: "+Collections.max(number_list));
        }
    }

    public void calcularPromedio() throws Exception {
        if (this.checkErrores()) {

        } else {
            int suma = 0;
            for (Integer num : number_list) {
                suma += num;
            }
            double promedio = (double) suma / number_list.size();
            logger.info("El promedio de la lista es: "+promedio);
        }

    }

    private boolean checkErrores() throws Exception{
        boolean respuesta = false;
        if (number_list.size() <= 0) {
            logger.error("El Array esta vacio.");
            respuesta = true;
            throw new Exception("El proceso no puede continuar, el Array esta vacio.");
        }
        return respuesta;
    }

}
