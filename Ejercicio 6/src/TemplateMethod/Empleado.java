package TemplateMethod;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int numeroCuenta;

    public Empleado(String nombre, String apellido, int numeroCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = numeroCuenta;
    }

    public void liquidarSueldo() {
        double sueldoTotal = calcularSueldo();
        if (sueldoTotal < 0.1) {
            try {
                throw new Exception("Error, al intentar calcular la liquidacion, el sueldo no puede ser 0 o menor.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String recibo = generarRecibo(sueldoTotal);
            depositarImporte(sueldoTotal, recibo);
        }

    }

    public abstract double calcularSueldo();

    public abstract String generarRecibo(double monto);

    public void depositarImporte(double monto, String recibo) {
        if (monto > 0) {
            System.out.println("La liquidacion generada es un documento " + recibo + ". Saldo a liquidar: " + monto + ".");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}

//“La liquidación generada es un documento impreso. Saldo a liquidar: 840”.
