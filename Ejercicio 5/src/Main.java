public class Main {
    public static void main(String[] args) {
        Infantil infantil1 = new Infantil(5,2);
        Vegetariano vegetariano1 = new Vegetariano(5,false,2);
        Clasico clasico1 = new Clasico(5);

        infantil1.informarArmadoPedido();
        System.out.println(infantil1.calcularPrecio());


        vegetariano1.informarArmadoPedido();
        System.out.println(vegetariano1.calcularPrecio());


        clasico1.informarArmadoPedido();
        System.out.println(clasico1.calcularPrecio());


    }
}
