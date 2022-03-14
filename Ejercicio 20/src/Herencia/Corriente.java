package Herencia;

public class Corriente extends Cuenta{
    @Override
    public boolean extraer(double monto) {
        setSaldo(getSaldo() - monto);
        return true;
    }
}
