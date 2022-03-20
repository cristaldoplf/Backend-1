package Serializacion;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pagina pagina1 = new Pagina("www.google.com", "Google");
        Pagina pagina2 = new Pagina("www.yahoo.com", "Yahoo");
        Pagina pagina3 = new Pagina("www.bing.com", "Bing");
        Pagina pagina4 = new Pagina("www.duckduckgo.com", "DuckDuckGo");

        ArrayList<Pagina> buscadores = new ArrayList<Pagina>();
        buscadores.add(pagina1);
        buscadores.add(pagina2);
        buscadores.add(pagina3);
        buscadores.add(pagina4);


        try {
            FileOutputStream fil = new FileOutputStream("Buscadores.dat");
            ObjectOutputStream archivo = new ObjectOutputStream(fil);

            archivo.writeObject(buscadores);
            archivo.close();

            FileInputStream filIn = new FileInputStream("Buscadores.dat");
            ObjectInputStream archivoIn = new ObjectInputStream(filIn);

            ArrayList<Pagina> lista_paginas = (ArrayList<Pagina>) archivoIn.readObject();

            for (Pagina pag : lista_paginas) {
                System.out.println(pag.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
