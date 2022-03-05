package PatronFacade;

public class Cuenta {
    private Integer identificacionUsuario; //DNI
    private double saldoActual;

    public Cuenta(Integer identificacionUsuario, double saldoActual) {
        this.identificacionUsuario = identificacionUsuario;
        this.saldoActual = saldoActual;
    }

    public Integer getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(Integer identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
}
