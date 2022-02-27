package Gobierno;

public class Diputado extends EmpleadoGobierno {

    public Diputado(EmpleadoGobierno sigEmpleadoGobierno) {
        super(sigEmpleadoGobierno);
    }

    @Override
    public void leerDocumento(Documento documento) {
        if (documento.getTipo() == 1){
            System.out.println("El diputado lee el documento y despues lo envia al ministro.");
        }else {
            System.out.println("El diputado no tiene la autorizacion para leer el documento y lo envia al ministro.");
        }
        if (this.getSigEmpleadoGobierno() != null){
            this.getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }
}
