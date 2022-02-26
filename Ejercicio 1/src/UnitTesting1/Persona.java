package UnitTesting1;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nom, String ape, int edad){
        nombre = nom;
        apellido = ape;
        this.edad = edad;
    }

    public String mostrarNombre(){
        return nombre+", "+apellido+".";
    }

    public boolean esMayor(){
        return this.edad>=18;
    }


}
