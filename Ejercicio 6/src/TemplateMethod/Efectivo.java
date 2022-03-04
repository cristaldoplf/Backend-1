package TemplateMethod;

public class Efectivo extends Empleado{
    private double sueldoBasico;
    private double descuentos;
    private double premios;

    public Efectivo(String nombre, String apellido, int numeroCuenta, double sueldoBasico, double descuentos, double premios) {
        super(nombre, apellido, numeroCuenta);
        this.sueldoBasico = sueldoBasico;
        this.descuentos = descuentos;
        this.premios = premios;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBasico+premios-descuentos;
    }

    @Override
    public String generarRecibo(double monto) {
        return "digital";
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }
}
