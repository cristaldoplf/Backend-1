package Felinos;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        try {
            Tigre tigre1 = new Tigre("Tiger", 5);
            Tigre tigre2 = new Tigre("Sherkhan", 15);

            Leon leon1 = new Leon("Leono",15,true);
            Leon leon2 = new Leon("Simba",5,false);

            logger.info("Los Tigres corren.");
            tigre1.correr();
            tigre2.correr();
            logger.info("Los leones corren");
            leon1.correr();
            leon2.correr();
            logger.info("¿Los Leones son viejos alfa?");
            leon1.esMayor();
            leon2.esMayor();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
