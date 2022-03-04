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

    public String liquidarSueldo() {
        double sueldoTotal = calcularSueldo();
        String respuesta = "Error";
        if (sueldoTotal < 0.1) {
            try {
                throw new Exception("Error, al intentar calcular la liquidación, el sueldo no puede ser 0 o menor.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String recibo = generarRecibo(sueldoTotal);
            respuesta = depositarImporte(sueldoTotal, recibo);
        }
        return respuesta;
    }

    public abstract double calcularSueldo();

    public abstract String generarRecibo(double monto);

    public String depositarImporte(double monto, String recibo) {
        String respuesta = "Error";
        if (monto > 0) {
            respuesta = "La liquidación generada es un documento " + recibo + ". Saldo a liquidar: " + monto;
            System.out.println(respuesta);

        }
        return respuesta;
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


