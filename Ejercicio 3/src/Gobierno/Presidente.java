package Gobierno;

public class Presidente extends EmpleadoGobierno {

    public Presidente(EmpleadoGobierno sigEmpleadoGobierno) {
        super(sigEmpleadoGobierno);
    }

    @Override
    public void leerDocumento(Documento documento) {

        System.out.println("El Presidente lee el documento.");

        if (this.getSigEmpleadoGobierno() != null) {
            this.getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }
}
