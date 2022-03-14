package Herencia;

public class Main {
    public static void main(String[] args) {
        System.out.println("Caja de ahorro");
        Cuenta cuenta = new CajaAhorro();
        cuenta.setSaldo(1000);
        cuenta.extraer(500);
        System.out.println(cuenta.getSaldo());
        cuenta.extraer(600);
        System.out.println(cuenta.getSaldo()+"\n");

        System.out.println("Cuenta Corriente");
        Cuenta cuenta1 = new Corriente();
        cuenta1.setSaldo(1000);
        cuenta1.extraer(500);
        System.out.println(cuenta1.getSaldo());
        cuenta1.extraer(600);
        System.out.println(cuenta1.getSaldo());


    }
}
