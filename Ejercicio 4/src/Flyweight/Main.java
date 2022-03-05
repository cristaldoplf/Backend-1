package Flyweight;

public class Main {
    public static void main(String[] args) {
        ListaDeReproduccion listaDeCanciones = new ListaDeReproduccion("Lista de Pablo");
        CancionFactory factory = new CancionFactory();

        listaDeCanciones.addCancion(factory,"Panic Show","La Renga","Rock");
        listaDeCanciones.addCancion(factory,"Mariposa Tecknicolor","Fito Paez","Pop");
        listaDeCanciones.addCancion(factory,"Welcome to The Jungle","Guns N' Roses","Hard Rock");
        listaDeCanciones.addCancion(factory,"Panic Show","La Renga","Rock");
        listaDeCanciones.addCancion(factory,"Welcome to The Jungle","Guns N' Roses","Hard Rock");



        System.out.println(listaDeCanciones.getLista().get(0).getNombre());
        System.out.println(listaDeCanciones.getLista().get(1).getNombre());
        System.out.println(listaDeCanciones.getLista().get(2).getNombre());
        System.out.println(listaDeCanciones.getLista().get(3).getNombre());
        System.out.println("");

        listaDeCanciones.mostrarLista();
    }
}
