package PatronFacade;

import java.util.ArrayList;
import java.util.List;

public class CuentaService {

    List<Cuenta> lista_cuentas;

    public CuentaService() {
        lista_cuentas = new ArrayList<>();
    }

    public void addCuenta(Cuenta cuenta){
        lista_cuentas.add(cuenta);
    }

    public Cuenta getCuenta(Integer DNI){
        Cuenta respuesta = null;
        for (Cuenta cue:lista_cuentas) {
            if (cue.getIdentificacionUsuario() == DNI){
                respuesta = cue;
            }
        }
        return respuesta;
    }

}
