package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Efectivo efectivo = new Efectivo("Martin","Martiti",111,400,40,60);
        Contratado contratado = new Contratado("Pompilia","Pompini",222,120,7);
        Efectivo efectivoError = new Efectivo("Martin","Martiti",111,400,500,60);

        efectivo.liquidarSueldo();
        contratado.liquidarSueldo();
        efectivoError.liquidarSueldo();
    }
}
