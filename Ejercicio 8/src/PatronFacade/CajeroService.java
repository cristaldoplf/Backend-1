package PatronFacade;

public class CajeroService implements ICajeroService {
    private AutenticationService autenticationService;
    private CuentaService cuentaService;
    private CajaService cajaService;

    public CajeroService(AutenticationService autenticationService, CuentaService cuentaService, CajaService cajaService) {
        this.autenticationService = autenticationService;
        this.cuentaService = cuentaService;
        this.cajaService = cajaService;
    }


    @Override
    public void procesarExtraccion(int DNI, String contrasenia, double monto) {
        Cuenta cuenta;
        if (autenticationService.validarUsuarioYContrasenia(DNI, contrasenia)) {
            if (cuentaService.getCuenta(DNI) != null) {
                cuenta = cuentaService.getCuenta(DNI);
                if (cuenta.getSaldoActual() >= monto) {
                    cajaService.entregarDinero(monto);
                    cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
                    System.out.println("Su saldo actual es de: $"+cuenta.getSaldoActual());
                } else {
                    System.out.println("Fondos insuficientes.");
                }
            } else {
                System.out.println("La cuenta no existe.");
            }
        } else {
            System.out.println("Datos de ingreso incorrectos.");
        }
    }
}
