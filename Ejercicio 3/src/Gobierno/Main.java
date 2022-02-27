package Gobierno;

public class Main{
    public static void main(String[] args) {
        Documento documento1 = new Documento("contenido secretisimo 1",1);
        Documento documento2 = new Documento("contenido secretisimo 2",2);
        Documento documento3 = new Documento("contenido secretisimo 3",3);

        Diputado diputado = new Diputado(new Ministro(new Presidente(null)));

        diputado.leerDocumento(documento1);
        System.out.println("");
        diputado.leerDocumento(documento2);
        System.out.println("");
        diputado.leerDocumento(documento3);
    }
}
