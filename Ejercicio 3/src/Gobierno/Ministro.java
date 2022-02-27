package Gobierno;

public class Ministro extends EmpleadoGobierno {

    public Ministro(EmpleadoGobierno sigEmpleadoGobierno) {
        super(sigEmpleadoGobierno);
    }

    @Override
    public void leerDocumento(Documento documento) {
        if (documento.getTipo() <= 2) {
            System.out.println("El Ministro lee el documento y despues lo envia al Presidente.");
        } else {
            System.out.println("El Ministro no tiene la autorizacion para leer el documento y lo envia al Presidente.");
        }
        if (this.getSigEmpleadoGobierno() != null) {
            this.getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }
}

