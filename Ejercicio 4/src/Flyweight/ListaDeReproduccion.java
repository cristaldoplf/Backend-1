package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {
    private String nombre;
    private List<Cancion> lista;

    public ListaDeReproduccion(String nombre) {
        this.nombre = nombre;
        lista = new ArrayList<>();
    }

    public void addCancion(CancionFactory factory, String nombre, String artista, String genero){
        lista.add(factory.getCancion(nombre,artista,genero));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getLista() {
        return lista;
    }

    public void setLista(List<Cancion> lista) {
        this.lista = lista;
    }
}
