package PatronFacade;

public class AutenticationService {
    public boolean validarUsuarioYContrasenia(Integer DNI, String contrasenia){
        boolean respuesta = false;

        if (DNI != null && contrasenia != null){
            respuesta = true;
        }
        return respuesta;
    }
}
