package Gobierno;

public abstract class EmpleadoGobierno {
    private EmpleadoGobierno sigEmpleadoGobierno;


    public EmpleadoGobierno(EmpleadoGobierno sigEmpleadoGobierno) {
        this.sigEmpleadoGobierno = sigEmpleadoGobierno;

    }

    public EmpleadoGobierno getSigEmpleadoGobierno() {
        return sigEmpleadoGobierno;
    }

    public EmpleadoGobierno setSigEmpleadoGobierno(EmpleadoGobierno sigEmpleadoGobierno) {
        this.sigEmpleadoGobierno = sigEmpleadoGobierno;
        return this;
    }

    public abstract void leerDocumento(Documento documento);


}
