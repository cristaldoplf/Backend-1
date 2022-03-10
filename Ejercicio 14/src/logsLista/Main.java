package logsLista;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {

            Lista lista1 = new Lista();
            lista1.getNumber_list().add(1);
            lista1.getNumber_list().add(2);
            lista1.getNumber_list().add(3);
            lista1.getNumber_list().add(4);
            lista1.getNumber_list().add(9);
            lista1.getNumber_list().add(8);
            lista1.getNumber_list().add(7);
            lista1.getNumber_list().add(6);
            lista1.getNumber_list().add(5);
            lista1.getNumber_list().add(4);
            lista1.getNumber_list().add(3);
            lista1.getNumber_list().add(2);


            lista1.calcularPromedio();
            lista1.calcularMaximo();
            lista1.calcularMinimo();

            lista1 = new Lista();
            lista1.calcularPromedio();
            lista1.calcularMaximo();
            lista1.calcularMinimo();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
