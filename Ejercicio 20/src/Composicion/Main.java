package Composicion;

public class Main {
    public static void main(String[] args) {
        //Herencia
        System.out.println("Herencia");
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
        System.out.println(cuenta1.getSaldo()+"\n");

        //Composicion
        System.out.println("Composicion");
        System.out.println("Caja de ahorro");
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setSaldo(2000);
        cuenta2.setNumero(1001);
        cuenta2.setEstrategia(new EstrategiaCajaAhorro());
        cuenta2.extraer(2100);
        System.out.println(cuenta2.getSaldo()+"\n");

        System.out.println("Cuenta Corriente");
        cuenta2.setEstrategia(new EstrategiaCuentaCorriente());
        cuenta2.extraer(2100);
        System.out.println(cuenta2.getSaldo()+"\n");


    }
}
