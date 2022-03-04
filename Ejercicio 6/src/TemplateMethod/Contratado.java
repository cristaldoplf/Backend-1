package TemplateMethod;

public class Contratado extends Empleado{
    private double horasTrabajadas;
    private double tarifaHora;

    public Contratado(String nombre, String apellido, int numeroCuenta, double horasTrabajadas, double tarifaHora) {
        super(nombre, apellido, numeroCuenta);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas*tarifaHora;
    }

    @Override
    public String generarRecibo(double monto) {
        return "impreso";
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }
}
