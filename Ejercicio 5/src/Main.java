public class Main {
    public static void main(String[] args) {
        Infantil infantil1 = new Infantil(5,2);
        Vegetariano vegetariano1 = new Vegetariano(5,false,2);
        Clasico clasico1 = new Clasico(5);

        System.out.println(infantil1.informarArmadoPedido());
        System.out.println(infantil1.calcularPrecio());
        System.out.println("");

        System.out.println(vegetariano1.informarArmadoPedido());
        System.out.println(vegetariano1.calcularPrecio());
        System.out.println("");

        System.out.println(clasico1.informarArmadoPedido());
        System.out.println(clasico1.calcularPrecio());


    }
}
