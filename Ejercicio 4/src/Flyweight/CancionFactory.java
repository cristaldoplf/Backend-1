package Flyweight;

import java.util.HashMap;

public class CancionFactory {

    private HashMap<String, Cancion> canciones = new HashMap<>();
    Cancion cancionBuscada;

    public Cancion getCancion(String nombre, String artista, String genero) {
        cancionBuscada = canciones.get(nombre);
        if (cancionBuscada == null) {
            cancionBuscada = new Cancion(nombre, artista, genero);
            canciones.put("key:"+nombre+":"+artista+":"+genero, cancionBuscada);
            System.out.println("Se creo la cancion " + nombre + " para agregarla a la lista");
        }
        System.out.println("Se agrego la cancion " + nombre + " a la lista");
        return cancionBuscada;
    }

    public HashMap<String, Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(HashMap<String, Cancion> canciones) {
        this.canciones = canciones;
    }
}
